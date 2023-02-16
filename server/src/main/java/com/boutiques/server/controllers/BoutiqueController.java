package com.boutiques.server.controllers;

import com.boutiques.server.dtos.boutiques.BoutiqueCreationDTO;
import com.boutiques.server.dtos.boutiques.BoutiqueDTO;
import com.boutiques.server.entities.Boutique;
import com.boutiques.server.mappers.BoutiqueMapper;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/boutiques")
@AllArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Boutique", description = "La gestion des boutiques")
public class BoutiqueController {

    private final Logger logger = LoggerFactory.getLogger(BoutiqueController.class);

    @Autowired
    private BoutiqueServiceImpl boutiqueService;

    @Autowired
    private BoutiqueMapper boutiqueMapper;

    @Operation(summary = "La création d'une boutique", description = "Cette méthode crée une nouvelle boutique")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "BadRequest")})
    @PostMapping("/save-boutique")
    public ResponseEntity<BoutiqueDTO> createBoutique(@RequestBody @Valid BoutiqueCreationDTO boutiqueCreationDTO) {
        BoutiqueDTO boutique = boutiqueService.createBoutique(boutiqueCreationDTO);
        return new ResponseEntity<>(boutique, HttpStatus.OK);
    }

    @Operation(summary = "La modification d'une boutique", description = "Cette méthode permet de modifier une boutique")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "400", description = "BadRequest")})
    @PutMapping("/{id}")
    public ResponseEntity<BoutiqueCreationDTO> updateBoutique(@PathVariable Long id, @RequestBody @Valid BoutiqueCreationDTO boutiqueCreationDTO) {
        boutiqueService.updateBoutique(id,boutiqueCreationDTO);
        return new ResponseEntity<>(boutiqueCreationDTO,HttpStatus.OK);
    }

    @Operation(summary = "La suppression d'une boutique", description = "Cette méthode permet de supprimer une boutique")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No content"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "400", description = "BadRequest")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteBoutique(@PathVariable Long id) {

        boutiqueService.deleteBoutique(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "La liste des boutiques", description = "Cette méthode permet de lister les boutiques")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")})
    @GetMapping()
    public ResponseEntity<?> getAllBoutique() {
        List<BoutiqueDTO> boutiqueDTOS = new ArrayList<BoutiqueDTO>();
        List<Boutique> boutiques = boutiqueService.retreiveBoutique();
        boutiques.forEach(boutique -> {
            boutiqueDTOS.add(boutiqueMapper.boutiqueToBoutiqueDto(boutique));
        });
        return new ResponseEntity<>(boutiqueDTOS,HttpStatus.OK);
    }

    @Operation(summary = "Retourner une boutique spécifique", description = "Cette méthode permet de retourner une boutique spécifique")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")})
    @GetMapping("/{id}")
    public ResponseEntity<?> getBoutique(@PathVariable Long id) {
        BoutiqueDTO boutiqueDTOS = new BoutiqueDTO();
        Boutique boutique = boutiqueService.retreiveBoutiqueById(id).get();
        boutiqueDTOS = boutiqueMapper.boutiqueToBoutiqueDto(boutique);
        return new ResponseEntity<>(boutiqueDTOS,HttpStatus.OK);
    }
}
