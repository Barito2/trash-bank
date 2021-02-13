package com.enigma.trashbank.services;

import com.enigma.trashbank.entities.Saldo;
import com.enigma.trashbank.entities.SaldoSummary;

import java.util.List;

public interface SaldoService extends CommonService<Saldo, Integer> {
    List<SaldoSummary> findAllSummaries();
}
