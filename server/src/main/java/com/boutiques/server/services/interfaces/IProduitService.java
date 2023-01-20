package com.boutiques.server.services.interfaces;

import com.boutiques.server.dtos.produits.ProduitCreationDTO;

public interface IProduitService {
    ProduitCreationDTO createProduit(Long id, ProduitCreationDTO produitCreationDTO);
    void updateProduit(Long id, ProduitCreationDTO produitCreationDTO);
}
