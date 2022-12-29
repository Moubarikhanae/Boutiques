package com.boutiques.server.mappers;

import com.boutiques.server.dtos.CategorieDTO;
import com.boutiques.server.entities.Categorie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CategorieMapper {

    public abstract Categorie categorieDtoToCategorie(CategorieDTO categorieDTO);

    public abstract CategorieDTO categorieToCategorieDto(Categorie categorie);

}
