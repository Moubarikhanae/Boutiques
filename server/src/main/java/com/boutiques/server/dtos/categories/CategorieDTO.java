package com.boutiques.server.dtos.categories;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CategorieDTO {

    @Getter
    @Setter
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "Le nom de la catégorie doit avoir au minimum 2 caractères")
    @Getter
    @Setter
    private String nom;

    public CategorieDTO() {
    }
}
