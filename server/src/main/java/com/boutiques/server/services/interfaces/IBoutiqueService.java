package com.boutiques.server.services.interfaces;

import com.boutiques.server.dtos.boutiques.BoutiqueCreationDTO;
import com.boutiques.server.dtos.boutiques.BoutiqueDTO;
import com.boutiques.server.entities.Boutique;

import java.util.List;
import java.util.Optional;

public interface IBoutiqueService {
    BoutiqueDTO createBoutique(BoutiqueCreationDTO boutiqueCreationDTO);
    void updateBoutique(Long id, BoutiqueCreationDTO boutiqueCreationDTO);
    void deleteBoutique(Long id);
    List<Boutique> retreiveBoutique();

    Optional<Boutique> retreiveBoutiqueById(Long id);
}
