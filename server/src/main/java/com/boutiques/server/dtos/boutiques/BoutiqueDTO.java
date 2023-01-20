package com.boutiques.server.dtos.boutiques;

import com.boutiques.server.dtos.ouvertures.OuvertureDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class BoutiqueDTO {
    @Getter
    @Setter
    private String nom;

    @Getter
    @Setter
    private boolean conge;

    @Getter
    @Setter
    private List<OuvertureDTO> ouvertures = new ArrayList<OuvertureDTO>();
}
