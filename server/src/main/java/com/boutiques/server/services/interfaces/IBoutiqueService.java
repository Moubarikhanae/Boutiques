package com.boutiques.server.services.interfaces;

import com.boutiques.server.dtos.boutiques.BoutiqueCreationDTO;
import com.boutiques.server.entities.Boutique;

public interface IBoutiqueService {
    Boutique createBoutique(BoutiqueCreationDTO boutiqueCreationDTO);
}
