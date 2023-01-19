package com.boutiques.server.mappers;

import com.boutiques.server.dtos.boutiques.BoutiqueCreationDTO;
import com.boutiques.server.dtos.categories.CategorieCreationDTO;
import com.boutiques.server.dtos.categories.CategorieDTO;
import com.boutiques.server.entities.Boutique;
import com.boutiques.server.entities.Categorie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CategorieMapper {


    //<editor-fold desc="Mapping category <-> categoryDTO ">
    public abstract Categorie categorieDtoToCategorie(CategorieDTO categorieDTO);

    public abstract CategorieDTO categorieToCategorieDto(Categorie categorie);
    //</editor-fold>

    //<editor-fold desc="Mapping category <-> categoryCreationDTO">
    public abstract Categorie categorieCreationDtoToCategorie(CategorieCreationDTO categorieCreationDTO);
    public abstract CategorieCreationDTO categorieToCategorieCreationDto(Categorie categorie);
    //</editor-fold>


}
