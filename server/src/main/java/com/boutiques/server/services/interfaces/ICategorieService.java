package com.boutiques.server.services.interfaces;

import com.boutiques.server.entities.Categorie;

import java.util.Optional;

public interface ICategorieService {
    Categorie createCategory(Categorie categorie);
    Optional<Categorie> findCategorieByName(String name);
}
