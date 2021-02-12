package com.enigma.trashbank.controllers;

import com.enigma.trashbank.entities.Unit;
import com.enigma.trashbank.exceptions.EntityNotFoundException;
import com.enigma.trashbank.models.PagedList;
import com.enigma.trashbank.models.ResponseMessage;
import com.enigma.trashbank.models.unit.UnitModel;
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
@CrossOrigin()
public class UnitController {

    @Autowired
    private UnitService service;

    @Autowired
    private ModelMapper modelMapper;

    @Operation(summary = "Add unit", description = "Add an unit for item measurement", tags = {"unit"})
    @PostMapping(produces = "application/json")
    public ResponseMessage<UnitModel> add(@RequestBody @Valid UnitModel model) {
        Unit entity = modelMapper.map(model, Unit.class);
        entity = service.save(entity);
        UnitModel data = modelMapper.map(entity, UnitModel.class);
        return ResponseMessage.success(data);
    }

    @Operation(summary = "Edit unit", description = "Edit an unit for item measurement", tags = {"unit"})
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseMessage<UnitModel> edit(@PathVariable Integer id, @RequestBody @Valid UnitModel model) {
        Unit entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        modelMapper.map(model, entity);
        service.save(entity);

        UnitModel data = modelMapper.map(entity, UnitModel.class);
        return ResponseMessage.success(data);
    }

    @Operation(summary = "Delete unit", description = "Delete an unit", tags = {"unit"})
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseMessage<UnitModel> removeById(@PathVariable Integer id) {
        Unit entity = service.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        UnitModel data = modelMapper.map(entity, UnitModel.class);

        return ResponseMessage.success(data);
    }

    @Operation(summary = "Find unit", description = "Find an unit", tags = {"unit"})
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseMessage<UnitModel> findById(@PathVariable Integer id) {
        Unit entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        UnitModel data = modelMapper.map(entity, UnitModel.class);

        return ResponseMessage.success(data);
    }

    @Operation(summary = "Get all unit", description = "Get all unit", tags = {"unit"})
    @GetMapping(produces = "application/json")
    public ResponseMessage<PagedList<UnitModel>> findAll(
            @Valid UnitSearch model
    ) {
        Unit search = modelMapper.map(model, Unit.class);

        Page<Unit> entityPage = service.findAll(search, model.getPage() - 1, model.getSize(), model.getSort());

        List<Unit> entities = entityPage.toList();

        List<UnitModel> models = entities.stream()
                .map(e -> modelMapper.map(e, UnitModel.class))
                .collect(Collectors.toList());

        PagedList<UnitModel> data = new PagedList<>(models,
                entityPage.getNumber() + 1,
                entityPage.getTotalPages(),
                entityPage.getSize(),
                entityPage.getTotalElements());

        return ResponseMessage.success(data);
    }



}
