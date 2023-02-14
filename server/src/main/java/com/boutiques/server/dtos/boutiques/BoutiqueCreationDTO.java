package com.boutiques.server.dtos.boutiques;

import com.boutiques.server.entities.Ouverture;
import lombok.Getter;
import lombok.Setter;


import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

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
    @Valid
    private List<Ouverture> ouvertures = new ArrayList<>();

}
