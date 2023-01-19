package com.boutiques.server.services.interfaces;

import com.boutiques.server.dtos.categories.CategorieCreationDTO;
import com.boutiques.server.entities.Categorie;

import java.util.List;
import java.util.Optional;

public interface ICategorieService {
    Categorie createCategory(CategorieCreationDTO categorie);
    Optional<Categorie> findCategorieByName(String name);
    Optional<Categorie> findCategorieById(Long id);
    void updateCategory(Long id, CategorieCreationDTO categorieCreationDTO);
    void deleteCategory(Long id);
    List<Categorie> retreiveCategories();

}
