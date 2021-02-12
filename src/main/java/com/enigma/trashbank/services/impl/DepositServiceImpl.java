package com.enigma.trashbank.services.impl;

import com.enigma.trashbank.entities.Deposit;
import com.enigma.trashbank.repositories.DepositRepository;
import com.enigma.trashbank.services.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositServiceImpl extends CommonServiceImpl<Deposit, Integer> implements DepositService {

    @Autowired
    public DepositServiceImpl(DepositRepository repository) {
        super(repository);
    }
}
