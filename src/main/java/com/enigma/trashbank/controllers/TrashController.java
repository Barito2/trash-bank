package com.enigma.trashbank.controllers;

import com.enigma.trashbank.entities.Trash;
import com.enigma.trashbank.entities.Unit;
import com.enigma.trashbank.exceptions.EntityNotFoundException;
import com.enigma.trashbank.models.PagedList;
import com.enigma.trashbank.models.ResponseMessage;
import com.enigma.trashbank.models.trash.TrashElement;
import com.enigma.trashbank.models.trash.TrashRequest;
import com.enigma.trashbank.models.trash.TrashResponse;
import com.enigma.trashbank.models.trash.TrashSearch;
import com.enigma.trashbank.services.TrashService;
import com.enigma.trashbank.services.UnitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/trashs")
@RestController
public class TrashController {

    @Autowired
    private TrashService service;

    @Autowired
    private UnitService unitService;

    @Autowired
    private ModelMapper modelMapper;

    @Operation(summary = "Add trash", description = "Add an trash without image", tags = {"trash"})
    @PostMapping(produces = "application/json")
    public ResponseMessage<TrashResponse> add(@RequestBody @Valid TrashRequest model) {
        Trash entity = modelMapper.map(model, Trash.class);

        Unit unit = unitService.findById(model.getUnitId());
        entity.setUnit(unit);

        entity = service.save(entity);
        TrashResponse data = modelMapper.map(entity, TrashResponse.class);
        return ResponseMessage.success(data);
    }

    @Operation(summary = "Edit trash", description = "Edit an trash without image", tags = {"trash"})
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseMessage<TrashResponse> edit(@PathVariable Integer id, @RequestBody @Valid TrashRequest model) {
        Trash entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        model = getRequest(model, entity);

        modelMapper.map(model, entity);
        service.save(entity);

        TrashResponse data = modelMapper.map(entity, TrashResponse.class);

        return ResponseMessage.success(data);
    }

    @Operation(summary = "Delete trash", description = "Delete an trash", tags = {"trash"})
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseMessage<TrashResponse> removeById(@PathVariable Integer id) {
        Trash entity = service.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        TrashResponse data = modelMapper.map(entity, TrashResponse.class);

        return ResponseMessage.success(data);
    }

    @Operation(summary = "Find trash", description = "Find an Trash", tags = {"trash"})
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseMessage<TrashResponse> findById(@PathVariable Integer id) {
        Trash entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        TrashResponse data = modelMapper.map(entity, TrashResponse.class);

        return ResponseMessage.success(data);
    }

    @Operation(summary = "Get all trash", description = "Get all trash", tags = {"trash"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ResponseMessage.class))
            )})
    @GetMapping(produces = "application/json")
    public ResponseMessage<PagedList<TrashElement>> findAll(
            @Valid TrashSearch model
    ) {
        Trash search = modelMapper.map(model, Trash.class);

        Page<Trash> entityPage = service.findAll(search, model.getPage() - 1, model.getSize(), model.getSort());

        List<Trash> entities = entityPage.toList();

        List<TrashElement> models = entities.stream()
                .map(e -> modelMapper.map(e, TrashElement.class))
                .collect(Collectors.toList());

        PagedList<TrashElement> data = new PagedList<>(models,
                entityPage.getNumber() + 1,
                entityPage.getTotalPages(),
                entityPage.getSize(),
                entityPage.getTotalElements());

        return ResponseMessage.success(data);
    }

    public TrashRequest getRequest(TrashRequest request, Trash trash) {
        if (request.getName() == null) request.setName(trash.getName());
        if (request.getPrice() == null) request.setPrice(trash.getPrice());
        if (request.getUnitId() == null) request.setUnitId(trash.getUnit().getId());
        trash.setUnit(unitService.findById(request.getUnitId()));
        return request;
    }
}
