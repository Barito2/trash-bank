package com.enigma.trashbank.repositories;

import com.enigma.trashbank.entities.SaldoSummary;

import java.util.List;

public interface SaldoSummaryRepository {
    List<SaldoSummary> findAllSummaries();
}
