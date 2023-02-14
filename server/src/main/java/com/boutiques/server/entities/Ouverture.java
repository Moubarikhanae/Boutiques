package com.boutiques.server.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @Min(value = 1, message = "Le jour doit être une valeur entre 1 (Lundi) et 7 (Dimanche).")
    @Max(value = 7, message = "Le jour doit être une valeur entre 1 (Lundi) et 7 (Dimanche).")
    private int jour;

    @ManyToOne
    @JoinColumn(name = "id_boutique")
    @Getter
    @Setter
    private Boutique boutique;



    public Ouverture() {
    }
}
