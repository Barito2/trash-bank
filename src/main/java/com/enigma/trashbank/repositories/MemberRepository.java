package com.enigma.trashbank.repositories;

import com.enigma.trashbank.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
