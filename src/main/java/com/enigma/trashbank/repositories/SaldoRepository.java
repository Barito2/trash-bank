package com.enigma.trashbank.repositories;

import com.enigma.trashbank.entities.Saldo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaldoRepository extends JpaRepository<Saldo, Integer>,SaldoSummaryRepository {
}
