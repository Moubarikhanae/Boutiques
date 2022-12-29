package com.boutiques.server.controllers;

import com.boutiques.server.commons.exceptions.BoutiqueException;
import com.boutiques.server.dtos.CategorieDTO;
import com.boutiques.server.entities.Categorie;
import com.boutiques.server.mappers.CategorieMapper;
import com.boutiques.server.services.interfaces.ICategorieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
@Tag(name = "Catégorie", description = "La gestion des catégories")
public class CategorieController {


    private ICategorieService categorieService;

    private CategorieMapper categorieMapper;

    @Operation(summary = "Création d'une catégorie", description = "Cette méthode crée une nouvelle catégorie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "BadRequest")})
    @PostMapping("/save-categorie")
    public ResponseEntity<CategorieDTO> createCategory(@RequestBody @Valid CategorieDTO categorieDTO) {

        //tester si le nom existe déjà, afin de respecter son unicité
        if (categorieService.findCategorieByName(categorieDTO.getNom()).isPresent()) {
            throw new BoutiqueException("La catégorie avec le nom" + categorieDTO.getNom() + " existe déjà");
        }

        Categorie categorie = categorieMapper.categorieDtoToCategorie(categorieDTO);
        categorieService.createCategory(categorie);

        return new ResponseEntity<>(categorieDTO, HttpStatus.OK);
    }


}
