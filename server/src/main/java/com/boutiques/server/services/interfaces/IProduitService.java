package com.boutiques.server.services.interfaces;

import com.boutiques.server.dtos.produits.ProduitCreationDTO;
import com.boutiques.server.dtos.produits.ProduitDTO;

import java.util.List;

public interface IProduitService {
    ProduitCreationDTO createProduit(Long id, ProduitCreationDTO produitCreationDTO);
    void updateProduit(Long id, ProduitCreationDTO produitCreationDTO);
    void deleteProduit(Long id);
    List<ProduitDTO> retreiveProduit();
}
