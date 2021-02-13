package com.enigma.trashbank.controllers;

import com.enigma.trashbank.entities.Deposit;
import com.enigma.trashbank.models.PagedList;
import com.enigma.trashbank.models.ResponseMessage;
import com.enigma.trashbank.models.deposit.DepositElement;
import com.enigma.trashbank.models.deposit.DepositSearch;
import com.enigma.trashbank.services.DepositService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/deposit")
@RestController
public class DepositController {

    @Autowired
    private DepositService service;

    @Autowired
    private ModelMapper modelMapper;

    @Operation(summary = "Get all trash", description = "Get all trash", tags = {"trash"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ResponseMessage.class))
            )})
    @GetMapping(produces = "application/json")
    public ResponseMessage<PagedList<DepositElement>> findAll(
            @Valid DepositSearch model
    ) {
        Deposit search = modelMapper.map(model, Deposit.class);

        Page<Deposit> entityPage = service.findAll(search, model.getPage() - 1, model.getSize(), model.getSort());

        List<Deposit> entities = entityPage.toList();

        List<DepositElement> models = entities.stream()
                .map(e -> modelMapper.map(e, DepositElement.class))
                .collect(Collectors.toList());

        PagedList<DepositElement> data = new PagedList<>(models,
                entityPage.getNumber() + 1,
                entityPage.getTotalPages(),
                entityPage.getSize(),
                entityPage.getTotalElements());

        return ResponseMessage.success(data);
    }

}
