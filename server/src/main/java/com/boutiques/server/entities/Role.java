package com.boutiques.server.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public enum Role {
    Anonyme(1, "Anonyme"),
    Administrateur(2, "Administrateur"),
    VendeurLivreur(3, "Vendeur-Livreur");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String roleName;

    Role(int id, String roleName){
        this.id = id;
        this.roleName = roleName;
    }

}
