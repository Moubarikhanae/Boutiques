package com.boutiques.server.services.interfaces;

import com.boutiques.server.dtos.produits.ProduitCreationDTO;
import com.boutiques.server.dtos.produits.ProduitDTO;
import com.boutiques.server.entities.Produit;

import java.util.List;
import java.util.Optional;

public interface IProduitService {
    ProduitCreationDTO createProduit(Long id, ProduitCreationDTO produitCreationDTO);
    void updateProduit(Long id, ProduitCreationDTO produitCreationDTO);
    void deleteProduit(Long id);
    List<ProduitDTO> retreiveProduit();
    ProduitDTO findProduitById(Long id);
}
