package com.enigma.trashbank.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@SQLDelete(sql = "UPDATE item SET is_deleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
public class Trash extends AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;
}
