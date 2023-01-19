package com.boutiques.server.services;

import com.boutiques.server.commons.exceptions.BoutiqueException;
import com.boutiques.server.controllers.CategorieController;
import com.boutiques.server.dtos.categories.CategorieCreationDTO;
import com.boutiques.server.entities.Categorie;
import com.boutiques.server.mappers.CategorieMapper;
import com.boutiques.server.repositories.CategorieRepository;
import com.boutiques.server.services.interfaces.ICategorieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements ICategorieService {

    private final Logger logger = LoggerFactory.getLogger(CategorieServiceImpl.class);

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private CategorieMapper categorieMapper;

    /**
     * La création d'une nouvelle catégorie
     * @param categorieCreationDTO entité categorie
     */
    @Override
    public Categorie createCategory(CategorieCreationDTO categorieCreationDTO) {
        //tester si le nom existe déjà, afin de respecter son unicité
        if (categorieRepository.findCategorieByNom(categorieCreationDTO.getNom()).isPresent()) {
            logger.error("La catégorie avec le nom: " +categorieCreationDTO.getNom()+ " existe déjà.");
            throw new BoutiqueException("La catégorie avec le nom" + categorieCreationDTO.getNom() + " existe déjà");
        }
        logger.trace("Début de crétaion d'une catégorie");
        Categorie categorie = categorieMapper.categorieCreationDtoToCategorie(categorieCreationDTO);
        Categorie categorieCreated = categorieRepository.save(categorie);
        logger.info("La catégorie" +categorieCreated.getNom()+ " est créée avec succès.");
          return categorieCreated;
    }

    @Override
    public Optional<Categorie> findCategorieByName(String name) {

        return categorieRepository.findCategorieByNom(name);
    }

    @Override
    public Optional<Categorie> findCategorieById(Long id) {
        return categorieRepository.findCategorieById(id);
    }

    @Override
    public void updateCategory(Long id, CategorieCreationDTO categorieCreationDTO) {
        Categorie categorie = categorieRepository.findCategorieById(id)
                .orElseThrow(()-> new BoutiqueException("La catégorie n'existe pas."));


        if (categorieRepository.findCategorieByNom(categorieCreationDTO.getNom()).isPresent() && !categorie.getNom().equals(categorieCreationDTO.getNom())) {
            logger.error("La catégorie avec le nom: " +categorieCreationDTO.getNom()+ " existe déjà.");
            throw new BoutiqueException("La catégorie avec le nom" + categorieCreationDTO.getNom() + " existe déjà");
        }

        categorie.setNom(categorieCreationDTO.getNom());
        logger.trace("Début de modification d'une catégorie");
        categorieRepository.save(categorie);
        logger.info("La catégorie" +categorie.getNom()+ " est modifiée avec succès.");

    }
    @Override
    public void deleteCategory(Long id) {
        Categorie categorie = categorieRepository.findCategorieById(id)
                .orElseThrow(()-> new BoutiqueException("La catégorie n'existe pas."));
        logger.trace("Début de suppression d'une catégorie");
        categorieRepository.delete(categorie);
        logger.info("La catégorie" +categorie.getNom()+ " est supprimée avec succès.");
    }

    @Override
    public List<Categorie> retreiveCategories() {
        return categorieRepository.findAll();
    }

}
