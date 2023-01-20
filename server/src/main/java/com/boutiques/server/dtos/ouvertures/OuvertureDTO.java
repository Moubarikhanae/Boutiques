package com.boutiques.server.dtos.ouvertures;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

public class OuvertureDTO {

    @Getter
    @Setter
    private Time horaireOuverture;

    @Getter
    @Setter
    private Time horaireFermeture;

    @Getter
    @Setter
    private int jour;

}
