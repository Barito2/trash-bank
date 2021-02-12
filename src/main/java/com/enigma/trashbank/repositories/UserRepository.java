package com.enigma.trashbank.repositories;
import com.enigma.trashbank.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}