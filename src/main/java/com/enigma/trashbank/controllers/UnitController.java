package com.enigma.trashbank.controllers;

import com.enigma.trashbank.entities.Unit;
import com.enigma.trashbank.exceptions.EntityNotFoundException;
import com.enigma.trashbank.models.PagedList;
import com.enigma.trashbank.models.ResponseMessage;
import com.enigma.trashbank.models.unit.UnitElement;
import com.enigma.trashbank.models.unit.UnitRequest;
import com.enigma.trashbank.models.unit.UnitResponse;
import com.enigma.trashbank.models.unit.UnitSearch;
import com.enigma.trashbank.services.UnitService;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/units")
@RestController
public class UnitController {

    @Autowired
    private UnitService service;

    @Autowired
    private ModelMapper modelMapper;

    @Operation(summary = "Add unit", description = "Add an unit for item measurement", tags = {"unit"})
    @PostMapping(produces = "application/json")
    public ResponseMessage<UnitResponse> add(@RequestBody @Valid UnitRequest model) {
        Unit entity = modelMapper.map(model, Unit.class);
        entity = service.save(entity);
        UnitResponse data = modelMapper.map(entity, UnitResponse.class);
        return ResponseMessage.success(data);
    }

    @Operation(summary = "Edit unit", description = "Edit an unit for item measurement", tags = {"unit"})
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseMessage<UnitResponse> edit(@PathVariable Integer id, @RequestBody @Valid UnitRequest model) {
        Unit entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        modelMapper.map(model, entity);
        service.save(entity);

        UnitResponse data = modelMapper.map(entity, UnitResponse.class);
        return ResponseMessage.success(data);
    }

    @Operation(summary = "Delete unit", description = "Delete an unit", tags = {"unit"})
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseMessage<UnitResponse> removeById(@PathVariable Integer id) {
        Unit entity = service.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        UnitResponse data = modelMapper.map(entity, UnitResponse.class);

        return ResponseMessage.success(data);
    }

    @Operation(summary = "Find unit", description = "Find an unit", tags = {"unit"})
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseMessage<UnitResponse> findById(@PathVariable Integer id) {
        Unit entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        UnitResponse data = modelMapper.map(entity, UnitResponse.class);

        return ResponseMessage.success(data);
    }

    @Operation(summary = "Get all unit", description = "Get all unit", tags = {"unit"})
    @GetMapping(produces = "application/json")
    public ResponseMessage<PagedList<UnitElement>> findAll(
            @Valid UnitSearch model
    ) {
        Unit search = modelMapper.map(model, Unit.class);

        Page<Unit> entityPage = service.findAll(search, model.getPage() - 1, model.getSize(), model.getSort());

        List<Unit> entities = entityPage.toList();

        List<UnitElement> models = entities.stream()
                .map(e -> modelMapper.map(e, UnitElement.class))
                .collect(Collectors.toList());

        PagedList<UnitElement> data = new PagedList<>(models,
                entityPage.getNumber() + 1,
                entityPage.getTotalPages(),
                entityPage.getSize(),
                entityPage.getTotalElements());

        return ResponseMessage.success(data);
    }



}
