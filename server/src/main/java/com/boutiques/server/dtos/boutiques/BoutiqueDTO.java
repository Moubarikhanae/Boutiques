package com.boutiques.server.dtos.boutiques;

import com.boutiques.server.dtos.ouvertures.OuvertureDTO;
import com.boutiques.server.dtos.produits.ProduitDTO;
import com.boutiques.server.entities.Produit;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BoutiqueDTO {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String nom;

    @Getter
    @Setter
    private boolean conge;

    @Getter
    @Setter
    private Date dateCreation;

    @Getter
    @Setter
    private List<OuvertureDTO> ouvertures = new ArrayList<OuvertureDTO>();

    @Getter
    @Setter
    private List<ProduitDTO> produitSet = new ArrayList<>();
}
