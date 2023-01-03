package com.boutiques.server.controllers;

import com.boutiques.server.commons.exceptions.BoutiqueException;
import com.boutiques.server.dtos.categories.CategorieCreationDTO;
import com.boutiques.server.dtos.categories.CategorieDTO;
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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
@Tag(name = "Catégorie", description = "La gestion des catégories")
public class CategorieController {


    private ICategorieService categorieService;

    private CategorieMapper categorieMapper;

    @Operation(summary = "La création d'une catégorie", description = "Cette méthode crée une nouvelle catégorie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "BadRequest")})
    @PostMapping("/save-categorie")
    public ResponseEntity<CategorieCreationDTO> createCategory(@RequestBody @Valid CategorieCreationDTO categorieCreationDTO) {

        //tester si le nom existe déjà, afin de respecter son unicité
        if (categorieService.findCategorieByName(categorieCreationDTO.getNom()).isPresent()) {
            throw new BoutiqueException("La catégorie avec le nom" + categorieCreationDTO.getNom() + " existe déjà");
        }

        Categorie categorie = categorieMapper.categorieCreationDtoToCategorie(categorieCreationDTO);
        categorieService.createCategory(categorie);

        return new ResponseEntity<>(categorieCreationDTO, HttpStatus.OK);
    }

    @Operation(summary = "La modification d'une catégorie", description = "Cette méthode permet de modifier une catégorie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "400", description = "BadRequest")})
    @PutMapping("/{id}")
    public ResponseEntity<CategorieCreationDTO> updateCategory(@PathVariable Long id, @RequestBody @Valid CategorieCreationDTO categorieCreationDTO) {
        Categorie categorie = categorieService.findCategorieById(id)
                .orElseThrow(()-> new BoutiqueException("La catégorie n'existe pas."));
        categorie.setNom(categorieCreationDTO.getNom());
        categorieService.updateCategory(categorie);
        return new ResponseEntity<>(categorieCreationDTO,HttpStatus.OK);
    }


    @Operation(summary = "La suppression d'une catégorie", description = "Cette méthode permet de supprimer une catégorie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No content"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "400", description = "BadRequest")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteCategory(@PathVariable Long id) {
        Categorie categorie = categorieService.findCategorieById(id)
                .orElseThrow(()-> new BoutiqueException("La catégorie n'existe pas."));
        categorieService.deleteCategory(categorie);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
