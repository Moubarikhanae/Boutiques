package com.boutiques.server.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(nullable = false, unique = true)
    @Getter
    @Setter
    private String nom;

    @ManyToMany(mappedBy = "categorieSet")
    private Set<Produit> produitSet = new HashSet<Produit>();
    public Categorie() {
    }
}
