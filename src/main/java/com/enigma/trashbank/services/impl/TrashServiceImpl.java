package com.enigma.trashbank.services.impl;

import com.enigma.trashbank.entities.Trash;
import com.enigma.trashbank.repositories.TrashRepository;
import com.enigma.trashbank.services.TrashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrashServiceImpl extends CommonServiceImpl<Trash, Integer> implements TrashService {

    @Autowired
    public TrashServiceImpl(TrashRepository repository) {
        super(repository);
    }
}
