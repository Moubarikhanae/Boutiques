package com.boutiques.server.dtos.produits;

import com.boutiques.server.entities.Categorie;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class ProduitDTO {

    @Getter
    @Setter
    private Long id;

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
    private Long quantite;

    @Getter
    @Setter
    private List<AssociatedCategorieDTO> categorieSet = new ArrayList<AssociatedCategorieDTO>();

}
