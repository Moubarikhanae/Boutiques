package com.boutiques.server.dtos.boutiques;

import com.boutiques.server.entities.Ouverture;
import com.boutiques.server.entities.Produit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class BoutiqueCreationDTO {

    @NotEmpty
    @Size(min = 2, message = "Le nom de la boutique doit avoir au minimum 2 caractères")
    @Getter
    @Setter
    private String nom;

    @Getter
    @Setter
    private boolean conge;

    @Getter
    @Setter
    private Set<Ouverture> ouvertures = new HashSet<Ouverture>();

}
