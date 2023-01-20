package com.boutiques.server.dtos.produits;

import com.boutiques.server.entities.Boutique;
import com.boutiques.server.entities.Categorie;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class ProduitCreationDTO {
    @NotEmpty
    @Size(min = 2, message = "Le nom du produit doit avoir au minimum 2 caractères")
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
    private List<Categorie> categorieSet = new ArrayList<Categorie>();
}
