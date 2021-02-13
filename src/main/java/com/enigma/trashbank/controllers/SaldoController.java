package com.enigma.trashbank.controllers;

import com.enigma.trashbank.entities.Saldo;
import com.enigma.trashbank.entities.SaldoSummary;
import com.enigma.trashbank.models.PagedList;
import com.enigma.trashbank.models.ResponseMessage;
import com.enigma.trashbank.models.saldo.SaldoElement;
import com.enigma.trashbank.models.saldo.SaldoSearch;
import com.enigma.trashbank.models.saldo.SaldoSummaryResponse;
import com.enigma.trashbank.models.trash.TrashElement;
import com.enigma.trashbank.models.trash.TrashSearch;
import com.enigma.trashbank.services.SaldoService;
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

@RequestMapping("/saldo")
@RestController
public class SaldoController {

    @Autowired
    private SaldoService service;

    @Autowired
    private ModelMapper modelMapper;

    @Operation(summary = "Get all trash", description = "Get all trash", tags = {"trash"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ResponseMessage.class))
            )})
    @GetMapping(produces = "application/json")
    public ResponseMessage<PagedList<SaldoElement>> findAll(
            @Valid SaldoSearch model
    ) {
        Saldo search = modelMapper.map(model, Saldo.class);

        Page<Saldo> entityPage = service.findAll(search, model.getPage() - 1, model.getSize(), model.getSort());

        List<Saldo> entities = entityPage.toList();

        List<SaldoElement> models = entities.stream()
                .map(e -> modelMapper.map(e, SaldoElement.class))
                .collect(Collectors.toList());

        PagedList<SaldoElement> data = new PagedList<>(models,
                entityPage.getNumber() + 1,
                entityPage.getTotalPages(),
                entityPage.getSize(),
                entityPage.getTotalElements());

        return ResponseMessage.success(data);
    }

    @Operation(summary = "Get all saldo summary", description = "Get all saldo summary data", tags = {"saldo"})
    @GetMapping(value = "/summaries", produces = "application/json")
    public ResponseMessage<List<SaldoSummaryResponse>> findAllSummaries() {
        List<SaldoSummary> summaries = service.findAllSummaries();

        List<SaldoSummaryResponse> data = summaries.stream()
                .map(e -> modelMapper.map(e, SaldoSummaryResponse.class))
                .collect(Collectors.toList());

        return ResponseMessage.success(data);
    }

}
