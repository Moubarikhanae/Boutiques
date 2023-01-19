package com.boutiques.server.controllers;

import com.boutiques.server.dtos.boutiques.BoutiqueCreationDTO;
import com.boutiques.server.dtos.categories.CategorieCreationDTO;
import com.boutiques.server.entities.Boutique;
import com.boutiques.server.services.BoutiqueServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/boutiques")
@AllArgsConstructor
@Tag(name = "Boutique", description = "La gestion des boutiques")
public class BoutiqueController {

    private final Logger logger = LoggerFactory.getLogger(BoutiqueController.class);

    @Autowired
    private BoutiqueServiceImpl boutiqueService;

    @Operation(summary = "La création d'une boutique", description = "Cette méthode crée une nouvelle boutique")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "BadRequest")})
    @PostMapping("/save-boutique")
    public ResponseEntity<Boutique> createBoutique(@RequestBody @Valid BoutiqueCreationDTO boutiqueCreationDTO) {
        Boutique boutique = boutiqueService.createBoutique(boutiqueCreationDTO);
        return new ResponseEntity<>(boutique, HttpStatus.OK);
    }

    @Operation(summary = "La modification d'une boutique", description = "Cette méthode permet de modifier une boutique")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "400", description = "BadRequest")})
    @PutMapping("/{id}")
    public ResponseEntity<BoutiqueCreationDTO> updateCategory(@PathVariable Long id, @RequestBody @Valid BoutiqueCreationDTO boutiqueCreationDTO) {
        boutiqueService.updateBoutique(id,boutiqueCreationDTO);
        return new ResponseEntity<>(boutiqueCreationDTO,HttpStatus.OK);
    }
}
