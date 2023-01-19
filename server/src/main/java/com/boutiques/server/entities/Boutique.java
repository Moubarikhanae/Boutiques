package com.boutiques.server.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    private List<Produit> produitSet = new ArrayList<>();

    @OneToMany(mappedBy = "boutique")
    @Getter
    @Setter
    private List<Ouverture> ouvertures = new ArrayList<>();

    public Boutique() {
    }
}
