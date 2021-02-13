package com.enigma.trashbank.repositories.impl;

import com.enigma.trashbank.entities.Saldo;
import com.enigma.trashbank.entities.SaldoSummary;
import com.enigma.trashbank.repositories.SaldoSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class SaldoSummaryRepositoryImpl implements SaldoSummaryRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<SaldoSummary> findAllSummaries() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<SaldoSummary> criteria = builder.createQuery(SaldoSummary.class);
        Root<Saldo> root = criteria.from(Saldo.class);

        criteria.multiselect(root.get("member"), builder.sum(root.get("nominal")))
                .groupBy(root.get("member"));

        return entityManager.createQuery(criteria).getResultList();
    }

}
