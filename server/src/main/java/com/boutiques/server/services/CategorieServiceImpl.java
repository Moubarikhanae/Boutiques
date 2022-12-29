package com.boutiques.server.services;

import com.boutiques.server.entities.Categorie;
import com.boutiques.server.repositories.CategorieRepository;
import com.boutiques.server.services.interfaces.ICategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategorieServiceImpl implements ICategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    /**
     * La création d'une nouvelle catégorie
     * @param categorie entité categorie
     */
    @Override
    public Categorie createCategory(Categorie categorie) {
      Categorie categorieCreated = categorieRepository.save(categorie);
      return categorieCreated;
    }

    @Override
    public Optional<Categorie> findCategorieByName(String name) {
        return categorieRepository.findCategorieByNom(name);
    }
}
