package com.boutiques.server.controllers;

import com.boutiques.server.dtos.produits.ProduitCreationDTO;
import com.boutiques.server.services.interfaces.IProduitService;
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
@RequestMapping("/api/produits")
@AllArgsConstructor
@Tag(name = "Produits", description = "La gestion des produits")
public class ProduitController {

    private final Logger logger = LoggerFactory.getLogger(ProduitController.class);

    private IProduitService produitService;

    @Operation(summary = "La création d'un produit'", description = "Cette méthode crée un nouveau produit")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "BadRequest")})
    @PostMapping("{id}/save-produit")
    public ResponseEntity<ProduitCreationDTO> createProduit(@PathVariable Long id, @RequestBody @Valid ProduitCreationDTO produitCreationDTO) {
        ProduitCreationDTO produit = produitService.createProduit(id, produitCreationDTO);
        return new ResponseEntity<>(produit, HttpStatus.OK);
    }

    @Operation(summary = "La modification d'un produit'", description = "Cette méthode permet de modifier un produit")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "400", description = "BadRequest")})
    @PutMapping("/{id}")
    public ResponseEntity<ProduitCreationDTO> updateProduit(@PathVariable Long id, @RequestBody @Valid ProduitCreationDTO produitCreationDTO) {
        produitService.updateProduit(id,produitCreationDTO);
        return new ResponseEntity<>(produitCreationDTO,HttpStatus.OK);
    }

    @Operation(summary = "La suppression d'un produit", description = "Cette méthode permet de supprimer un produit")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No content"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "400", description = "BadRequest")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteProduit(@PathVariable Long id) {

        produitService.deleteProduit(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "La liste des produits", description = "Cette méthode permet de lister les produits")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")})
    @GetMapping()
    public ResponseEntity<?> getAllProduits() {
        return new ResponseEntity<>(produitService.retreiveProduit(),HttpStatus.OK);
    }
}
