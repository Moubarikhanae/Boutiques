package com.boutiques.server.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;

@Entity
public class Ouverture {

    @Id
    @Getter
    @Setter
    private OuvertureId ouvertureId;

    @Getter
    @Setter
    private Time horaireOuverture;

    @Getter
    @Setter
    private Time horaireFermeture;

    public Ouverture() {
    }
}
