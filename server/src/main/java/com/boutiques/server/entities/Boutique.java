package com.boutiques.server.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Boutique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(nullable = false, unique = true)
    @Getter
    @Setter
    private String nom;

    @Getter
    @Setter
    private boolean conge;

    @Getter
    @Setter
    private Date dateCreation;

    @OneToMany(mappedBy = "boutique")
    @Getter
    @Setter
    private Set<Produit> produitSet = new HashSet<Produit>();

    @OneToMany(mappedBy = "ouvertureId.boutique")
    @Getter
    @Setter
    private Set<Ouverture> ouvertures = new HashSet<Ouverture>();

    public Boutique() {
    }
}
