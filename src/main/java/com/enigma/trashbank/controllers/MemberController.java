package com.enigma.trashbank.controllers;

import com.enigma.trashbank.entities.Member;
import com.enigma.trashbank.exceptions.EntityNotFoundException;
import com.enigma.trashbank.models.PagedList;
import com.enigma.trashbank.models.ResponseMessage;
import com.enigma.trashbank.models.member.MemberModel;
import com.enigma.trashbank.models.member.MemberSearch;
import com.enigma.trashbank.services.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/members")
@RestController
public class MemberController {

    @Autowired
    private MemberService service;

    @Autowired
    private ModelMapper modelMapper;

    @Operation(summary = "Add member", description = "Add an member for item measurement", tags = {"member"})
    @PostMapping(produces = "application/json")
    public ResponseMessage<MemberModel> add(@RequestBody @Valid MemberModel model) {
        Member entity = modelMapper.map(model, Member.class);
        entity = service.save(entity);
        MemberModel data = modelMapper.map(entity, MemberModel.class);
        return ResponseMessage.success(data);
    }

    @Operation(summary = "Edit member", description = "Edit an member for item measurement", tags = {"member"})
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseMessage<MemberModel> edit(@PathVariable Integer id, @RequestBody @Valid MemberModel model) {
        Member entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        modelMapper.map(model, entity);
        service.save(entity);

        MemberModel data = modelMapper.map(entity, MemberModel.class);
        return ResponseMessage.success(data);
    }

    @Operation(summary = "Delete member", description = "Delete an member", tags = {"member"})
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseMessage<MemberModel> removeById(@PathVariable Integer id) {
        Member entity = service.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        MemberModel data = modelMapper.map(entity, MemberModel.class);

        return ResponseMessage.success(data);
    }

    @Operation(summary = "Find member", description = "Find an member", tags = {"member"})
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseMessage<MemberModel> findById(@PathVariable Integer id) {
        Member entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        MemberModel data = modelMapper.map(entity, MemberModel.class);

        return ResponseMessage.success(data);
    }

    @Operation(summary = "Get all member", description = "Get all member", tags = {"member"})
    @GetMapping(produces = "application/json")
    public ResponseMessage<PagedList<MemberModel>> findAll(
            @Valid MemberSearch model
    ) {
        Member search = modelMapper.map(model, Member.class);

        Page<Member> entityPage = service.findAll(search, model.getPage() - 1, model.getSize(), model.getSort());

        List<Member> entities = entityPage.toList();

        List<MemberModel> models = entities.stream()
                .map(e -> modelMapper.map(e, MemberModel.class))
                .collect(Collectors.toList());

        PagedList<MemberModel> data = new PagedList<>(models,
                entityPage.getNumber() + 1,
                entityPage.getTotalPages(),
                entityPage.getSize(),
                entityPage.getTotalElements());

        return ResponseMessage.success(data);
    }



}
