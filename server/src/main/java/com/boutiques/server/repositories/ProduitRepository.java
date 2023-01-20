package com.boutiques.server.repositories;

import com.boutiques.server.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
    Optional<Produit> findProduitByNom(String nom);
    Optional<Produit> findProduitById(Long id);
}
