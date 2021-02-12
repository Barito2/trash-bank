package com.enigma.trashbank.repositories;

import com.enigma.trashbank.entities.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepository extends JpaRepository<Deposit, Integer>  {
}
