package com.boutiques.server.mappers;


import com.boutiques.server.dtos.produits.ProduitCreationDTO;
import com.boutiques.server.dtos.produits.ProduitDTO;
import com.boutiques.server.entities.Produit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ProduitMapper {

    //<editor-fold desc="Mapping produit <-> produitCreationDTO">
    public abstract Produit produitCreationDtoToProduit(ProduitCreationDTO produitCreationDTO);
    public abstract ProduitCreationDTO produitToProduitCreationDto(Produit produit);
    //</editor-fold>

    //<editor-fold desc="Mapping produit <-> produitDTO">
    public abstract Produit produitDtoToProduit(ProduitDTO produitDTO);
    public abstract ProduitDTO produitToProduitDto(Produit produit);
    //</editor-fold>
}
