package com.boutiques.server.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Produit {
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
    private String description;

    @Getter
    @Setter
    private double prix;

    @Getter
    @Setter
    private Long quantité;

    @ManyToOne
    @JoinColumn(name = "id_boutique")
    @Getter
    @Setter
    private Boutique boutique;

    @ManyToMany()
    @JoinTable(name = "ProduitCategorie", joinColumns = @JoinColumn(name = "id_produit"),
    inverseJoinColumns = @JoinColumn(name = "id_categorie"))
    @Getter
    @Setter
    private List<Categorie> categorieSet = new ArrayList<Categorie>();

    public Produit() {
    }
}
