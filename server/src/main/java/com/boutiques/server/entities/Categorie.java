package com.boutiques.server.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    @ManyToMany(cascade = CascadeType.REMOVE, mappedBy = "categorieSet")
    private List<Produit> produitSet = new ArrayList<Produit>();
    public Categorie() {
    }
}
