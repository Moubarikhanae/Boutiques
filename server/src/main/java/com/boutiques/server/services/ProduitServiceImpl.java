package com.boutiques.server.services;

import com.boutiques.server.commons.exceptions.BoutiqueException;
import com.boutiques.server.dtos.produits.ProduitCreationDTO;
import com.boutiques.server.entities.Boutique;
import com.boutiques.server.entities.Produit;
import com.boutiques.server.mappers.ProduitMapper;
import com.boutiques.server.repositories.BoutiqueRepository;
import com.boutiques.server.repositories.ProduitRepository;
import com.boutiques.server.services.interfaces.IProduitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduitServiceImpl implements IProduitService {

    private final Logger logger = LoggerFactory.getLogger(ProduitServiceImpl.class);

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private ProduitMapper produitMapper;

    @Autowired
    private BoutiqueRepository boutiqueRepository;

    @Override
    public ProduitCreationDTO createProduit(Long id, ProduitCreationDTO produitCreationDTO) {
        //tester si le nom existe déjà, afin de respecter son unicité
        if (produitRepository.findProduitByNom(produitCreationDTO.getNom()).isPresent()) {
            logger.error("Le produit avec le nom: " +produitCreationDTO.getNom()+ " existe déjà.");
            throw new BoutiqueException("Le produit avec le nom" + produitCreationDTO.getNom() + " existe déjà");
        }
        Boutique boutique = boutiqueRepository.findBoutiqueById(id).orElseThrow(
                ()-> new BoutiqueException("La boutique n'existe pas."));
        logger.trace("Début de crétaion du produit");
        Produit produit = produitMapper.produitCreationDtoToProduit(produitCreationDTO);
        produit.setBoutique(boutique);
        Produit produit1 = produitRepository.save(produit);
        logger.info("Le produit" +produit1.getNom()+ " est créée avec succès.");
        return produitMapper.produitToProduitCreationDto(produit);
    }

    @Override
    public void updateProduit(Long id, ProduitCreationDTO produitCreationDTO) {
        Produit produit = produitRepository.findProduitById(id)
                .orElseThrow(()-> new BoutiqueException("Le produit n'existe pas."));

        if (produitRepository.findProduitByNom(produitCreationDTO.getNom()).isPresent() && !produit.getNom().equals(produitCreationDTO.getNom())) {
            logger.error("Le produit avec le nom: " +produitCreationDTO.getNom()+ " existe déjà.");
            throw new BoutiqueException("Le produit avec le nom" + produitCreationDTO.getNom() + " existe déjà");
        }

        produit.setNom(produitCreationDTO.getNom());
        produit.setDescription(produitCreationDTO.getDescription());
        produit.setPrix(produitCreationDTO.getPrix());
        produit.setQuantite(produitCreationDTO.getQuantite());
        produit.setCategorieSet(produitCreationDTO.getCategorieSet());
        produitRepository.save(produit);
    }

    @Override
    public void deleteProduit(Long id) {
        Produit produit = produitRepository.findProduitById(id)
                .orElseThrow(()-> new BoutiqueException("Le produit n'existe pas."));
        logger.trace("Début de suppression d'un produit");
        produitRepository.delete(produit);
        logger.info("Le produit" +produit.getNom()+ " est supprimée avec succès.");
    }
}
