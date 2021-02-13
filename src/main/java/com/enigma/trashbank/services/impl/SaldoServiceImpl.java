package com.enigma.trashbank.services.impl;

import com.enigma.trashbank.entities.Saldo;
import com.enigma.trashbank.entities.SaldoSummary;
import com.enigma.trashbank.repositories.SaldoRepository;
import com.enigma.trashbank.services.SaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaldoServiceImpl extends CommonServiceImpl<Saldo, Integer> implements SaldoService {

    @Autowired
    public SaldoServiceImpl(SaldoRepository repository) {
        super(repository);
    }

    @Override
    public List<SaldoSummary> findAllSummaries() {
        return ((SaldoRepository) repository).findAllSummaries();
    }
}
