package com.enigma.trashbank.services.impl;


import com.enigma.trashbank.entities.Unit;
import com.enigma.trashbank.repositories.UnitRepository;
import com.enigma.trashbank.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImpl extends CommonServiceImpl<Unit, Integer> implements UnitService {

    @Autowired
    public UnitServiceImpl(UnitRepository unitRepository) {
        super(unitRepository);
    }
}
