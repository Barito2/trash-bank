package com.enigma.trashbank.services.impl;


import com.enigma.trashbank.entities.Member;
import com.enigma.trashbank.repositories.MemberRepository;
import com.enigma.trashbank.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl extends CommonServiceImpl<Member, Integer> implements MemberService {

    @Autowired
    public MemberServiceImpl(MemberRepository unitRepository) {
        super(unitRepository);
    }
}
