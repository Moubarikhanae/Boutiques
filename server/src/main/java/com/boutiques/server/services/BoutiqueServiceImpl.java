package com.boutiques.server.services;

import com.boutiques.server.commons.exceptions.BoutiqueException;
import com.boutiques.server.dtos.boutiques.BoutiqueCreationDTO;
import com.boutiques.server.entities.Boutique;
import com.boutiques.server.mappers.BoutiqueMapper;
import com.boutiques.server.repositories.BoutiqueRepository;
import com.boutiques.server.repositories.OuvertreRepository;
import com.boutiques.server.services.interfaces.IBoutiqueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;


@Service
public class BoutiqueServiceImpl implements IBoutiqueService {

    private final Logger logger = LoggerFactory.getLogger(BoutiqueServiceImpl.class);

    @Autowired
    private BoutiqueRepository boutiqueRepository;

    @Autowired
    private OuvertreRepository ouvertreRepository;

    @Autowired
    private BoutiqueMapper boutiqueMapper;

    /**
     * La création d'une nouvelle boutique
     * @param boutiqueCreationDTO
     * @return Boutique créée
     */
    @Override
    public Boutique createBoutique(BoutiqueCreationDTO boutiqueCreationDTO) {
        //tester si le nom existe déjà, afin de respecter son unicité
        if(boutiqueRepository.findBoutiqueByNom(boutiqueCreationDTO.getNom()).isPresent()){
            logger.error("La boutique avec le nom: " +boutiqueCreationDTO.getNom()+ " existe déjà.");
            throw new BoutiqueException("La boutique avec le nom" + boutiqueCreationDTO.getNom() + " existe déjà");
        }
        logger.trace("Début de crétaion d'une boutique");
        Boutique boutique = boutiqueMapper.boutiqueCreationDtoToBoutique(boutiqueCreationDTO);
        Date date = Date.valueOf(LocalDate.now());
        boutique.setDateCreation(date);
        boutiqueRepository.save(boutique);
        //Ajouter les horaires
        ouvertreRepository.saveAll(boutiqueCreationDTO.getOuvertures());
        logger.info("La boutique" +boutiqueCreationDTO.getNom()+ " est créée avec succès.");
        return boutique;
    }
}
