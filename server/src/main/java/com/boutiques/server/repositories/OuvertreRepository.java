package com.boutiques.server.repositories;

import com.boutiques.server.entities.Ouverture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OuvertreRepository extends JpaRepository<Ouverture, Long> {
}
