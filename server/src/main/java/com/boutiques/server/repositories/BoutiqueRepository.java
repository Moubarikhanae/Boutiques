package com.boutiques.server.repositories;

import com.boutiques.server.entities.Boutique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoutiqueRepository extends JpaRepository<Boutique,Long> {

    Optional<Boutique> findBoutiqueByNom(String nom);
    Optional<Boutique> findBoutiqueById(Long id);
}
