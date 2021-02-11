package com.enigma.trashbank.repositories;

import com.enigma.trashbank.entities.Trash;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrashRepository extends JpaRepository<Trash, Integer> {
}
