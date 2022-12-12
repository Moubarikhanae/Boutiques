package com.boutiques.server.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class OuvertureId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_boutique")
    @Getter
    @Setter
    private Boutique boutique;

    @ManyToOne
    @JoinColumn(name = "id_jour")
    @Getter
    @Setter
    private Jour jour;

}
