package com.boutiques.server.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;

@Entity
public class Ouverture {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Time horaireOuverture;

    @Getter
    @Setter
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Time horaireFermeture;

    @Getter
    @Setter
    private int jour;

    @ManyToOne
    @JoinColumn(name = "id_boutique")
    @Getter
    @Setter
    private Boutique boutique;



    public Ouverture() {
    }
}
