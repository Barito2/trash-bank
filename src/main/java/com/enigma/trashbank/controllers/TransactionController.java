package com.enigma.trashbank.controllers;

import com.enigma.trashbank.entities.*;
import com.enigma.trashbank.models.ResponseMessage;
import com.enigma.trashbank.models.deposit.DepositRequest;
import com.enigma.trashbank.models.deposit.DepositResponse;
import com.enigma.trashbank.models.saldo.SaldoSummaryResponse;
import com.enigma.trashbank.services.DepositService;
import com.enigma.trashbank.services.MemberService;
import com.enigma.trashbank.services.SaldoService;
import com.enigma.trashbank.services.TrashService;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/deposit")
@RestController
public class TransactionController {

    @Autowired
    private DepositService depositService;

    @Autowired
    private SaldoService saldoService;

    @Autowired
    private TrashService trashService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ModelMapper modelMapper;

    @Operation(summary = "Add transaction", description = "Add an transaction without image", tags = {"transaction"})
    @PostMapping(produces = "application/json")
    public ResponseMessage<DepositResponse> add(@RequestBody @Valid DepositRequest model) {
        Deposit entity = modelMapper.map(model, Deposit.class);

        Trash trash = trashService.findById(model.getTrashId());
        entity.setTrash(trash);

        Member member = memberService.findById(model.getMemberId());
        entity.setMember(member);

        entity.setPrice((long) (model.getWeight() * trash.getPrice()));

        entity = depositService.save(entity);
        DepositResponse data = modelMapper.map(entity, DepositResponse.class);

        Saldo saldo = modelMapper.map(model, Saldo.class);
        saldo.setMember(member);
        saldo.setNominal(entity.getPrice());
        saldoService.save(saldo);

        return ResponseMessage.success(data);
    }

    @Operation(summary = "Get all stock summary", description = "Get all stock summary data", tags = {"stock"})
    @GetMapping(value = "/summaries", produces = "application/json")
    public ResponseMessage<List<SaldoSummaryResponse>> findAllSummaries() {
        List<SaldoSummary> summaries = saldoService.findAllSummaries();

        List<SaldoSummaryResponse> data = summaries.stream()
                .map(e -> modelMapper.map(e, SaldoSummaryResponse.class))
                .collect(Collectors.toList());

        return ResponseMessage.success(data);
    }

}
