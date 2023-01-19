package com.boutiques.server.mappers;

import com.boutiques.server.dtos.boutiques.BoutiqueCreationDTO;
import com.boutiques.server.entities.Boutique;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class BoutiqueMapper {

    //<editor-fold desc="Mapping boutique <-> boutiqueCreationDTO">
    public abstract Boutique boutiqueCreationDtoToBoutique(BoutiqueCreationDTO boutiqueCreationDTO);
    public abstract BoutiqueCreationDTO boutiqueToBoutiqueCreationDto(Boutique boutique);
    //</editor-fold>
}
