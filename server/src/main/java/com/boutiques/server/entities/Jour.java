package com.boutiques.server.entities;

import com.boutiques.server.commons.enums.EJour;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Jour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Getter
    @Setter
    private EJour JourSemaine;

    @OneToMany(mappedBy = "ouvertureId.jour")
    @Getter
    @Setter
    private Set<Ouverture> ouvertures = new HashSet<Ouverture>();

    public Jour() {
    }
}
