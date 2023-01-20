package com.boutiques.server.controllers;

import com.boutiques.server.dtos.categories.CategorieCreationDTO;
import com.boutiques.server.services.interfaces.ICategorieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(CategorieController.class);

    private ICategorieService categorieService;

    @Operation(summary = "La création d'une catégorie", description = "Cette méthode crée une nouvelle catégorie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "BadRequest")})
    @PostMapping("/save-categorie")
    public ResponseEntity<CategorieCreationDTO> createCategory(@RequestBody @Valid CategorieCreationDTO categorieCreationDTO) {
        categorieService.createCategory(categorieCreationDTO);
        return new ResponseEntity<>(categorieCreationDTO, HttpStatus.OK);
    }

    @Operation(summary = "La modification d'une catégorie", description = "Cette méthode permet de modifier une catégorie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "400", description = "BadRequest")})
    @PutMapping("/{id}")
    public ResponseEntity<CategorieCreationDTO> updateCategory(@PathVariable Long id, @RequestBody @Valid CategorieCreationDTO categorieCreationDTO) {
        categorieService.updateCategory(id, categorieCreationDTO);
        return new ResponseEntity<>(categorieCreationDTO,HttpStatus.OK);
    }

    @Operation(summary = "La suppression d'une catégorie", description = "Cette méthode permet de supprimer une catégorie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No content"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "400", description = "BadRequest")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteCategory(@PathVariable Long id) {

        categorieService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "La liste des categories", description = "Cette méthode permet de lister les catégories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")})
    @GetMapping()
    public ResponseEntity<?> getAllCategories() {
        return new ResponseEntity<>(categorieService.retreiveCategories(),HttpStatus.OK);
    }
}
