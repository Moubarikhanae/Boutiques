package com.boutiques.server.services;

import com.boutiques.server.commons.exceptions.*;
import com.boutiques.server.dtos.boutiques.BoutiqueCreationDTO;
import com.boutiques.server.dtos.boutiques.BoutiqueDTO;
import com.boutiques.server.entities.Boutique;
import com.boutiques.server.mappers.BoutiqueMapper;
import com.boutiques.server.repositories.BoutiqueRepository;
import com.boutiques.server.repositories.OuvertreRepository;
import com.boutiques.server.repositories.ProduitRepository;
import com.boutiques.server.services.interfaces.IBoutiqueService;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Service
public class BoutiqueServiceImpl implements IBoutiqueService {

    private final Logger logger = LoggerFactory.getLogger(BoutiqueServiceImpl.class);

    @Autowired
    private BoutiqueRepository boutiqueRepository;

    @Autowired
    private OuvertreRepository ouvertreRepository;

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private BoutiqueMapper boutiqueMapper;


    /**
     * La création d'une nouvelle boutique
     * @param boutiqueCreationDTO
     * @return Boutique créée
     */
    @Override
    public BoutiqueDTO createBoutique(BoutiqueCreationDTO boutiqueCreationDTO) {
        //tester si le nom existe déjà, afin de respecter son unicité
        if(boutiqueRepository.findBoutiqueByNom(boutiqueCreationDTO.getNom()).isPresent()){
            logger.error("La boutique avec le nom: " +boutiqueCreationDTO.getNom()+ " existe déjà.");
            throw new BoutiqueException("La boutique avec le nom " + boutiqueCreationDTO.getNom() + " existe déjà");
        }
        logger.trace("Début de crétaion d'une boutique");
        Boutique boutique = boutiqueMapper.boutiqueCreationDtoToBoutique(boutiqueCreationDTO);
        Date date = Date.valueOf(LocalDate.now());
        boutique.setDateCreation(date);
        boutiqueRepository.save(boutique);
        //Ajouter les horaires
        boutique.getOuvertures().forEach(ouverture -> {
            ouverture.setBoutique(boutique);
            if(ouverture.getJour() == 0) ouverture.setJour(1);
            ouvertreRepository.save(ouverture);
        });
        logger.info("La boutique " +boutiqueCreationDTO.getNom()+ " est créée avec succès.");
        BoutiqueDTO boutiqueDTO = boutiqueMapper.boutiqueToBoutiqueDto(boutique);
        return boutiqueDTO;
    }

    /**
     * Update boutique
     * @param id
     * @param boutiqueCreationDTO
     */
    @Override
    public void updateBoutique(Long id,BoutiqueCreationDTO boutiqueCreationDTO) {
        Boutique boutique = boutiqueRepository.findBoutiqueById(id)
                .orElseThrow(()-> new BoutiqueException("La boutique n'existe pas."));
        if (boutiqueRepository.findBoutiqueByNom(boutiqueCreationDTO.getNom()).isPresent() && !boutique.getNom().equals(boutiqueCreationDTO.getNom())) {
            logger.error("La boutique avec le nom: " +boutiqueCreationDTO.getNom()+ " existe déjà.");
            throw new BoutiqueException("La boutique avec le nom" + boutiqueCreationDTO.getNom() + " existe déjà");
        }
        boutique.setNom(boutiqueCreationDTO.getNom());
        boutique.setConge(boutiqueCreationDTO.isConge());
        for (int i=0 ; i<boutique.getOuvertures().size(); i++) {
            boutique.getOuvertures().get(i).setHoraireOuverture(
                    boutiqueCreationDTO.getOuvertures().get(i).getHoraireOuverture());
            boutique.getOuvertures().get(i).setHoraireFermeture(
                    boutiqueCreationDTO.getOuvertures().get(i).getHoraireFermeture());
        }
        boutiqueRepository.save(boutique);
        //Modifier les horaires
        ouvertreRepository.saveAll(boutique.getOuvertures());
    }

    /**
     * Delete boutique
     * @param id
     */
    @Override
    public void deleteBoutique(Long id) {
        Boutique boutique = boutiqueRepository.findBoutiqueById(id)
                .orElseThrow(()-> new BoutiqueException("La boutique n'existe pas."));
        logger.trace("Début de suppression d'une boutique");
        if(boutique.getOuvertures().size()!=0){
            //Pour la compositon supprimer les horaires associés
            ouvertreRepository.deleteAll(boutique.getOuvertures());
        }
        if(boutique.getProduitSet().size()!=0){
            //Pour la compositon supprimer les produits associés
            produitRepository.deleteAll(boutique.getProduitSet());
        }
        boutiqueRepository.delete(boutique);
        logger.info("La boutique" +boutique.getNom()+ " est supprimée avec succès.");
    }

    /**
     * Display all boutique
     * @return list
     */
    @Override
    public List<Boutique> retreiveBoutique() {
        return boutiqueRepository.findAll();
    }
}
