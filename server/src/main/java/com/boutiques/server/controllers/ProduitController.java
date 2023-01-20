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
}
