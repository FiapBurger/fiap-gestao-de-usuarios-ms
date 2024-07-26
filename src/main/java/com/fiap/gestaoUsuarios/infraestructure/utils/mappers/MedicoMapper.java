package com.fiap.gestaoUsuarios.infraestructure.utils.mappers;

import com.fiap.gestaoUsuarios.core.domains.entities.MedicoDTO;
import com.fiap.gestaoUsuarios.infraestructure.api.requests.MedicoRequest;
import com.fiap.gestaoUsuarios.infraestructure.api.responses.MedicoResponse;
import com.fiap.gestaoUsuarios.infraestructure.persistence.entities.MedicoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicoMapper {
    MedicoResponse toMedicoResponse(MedicoEntity medicoEntity);
    MedicoEntity toMedicoEntity(MedicoDTO medicoDTO);
    MedicoDTO toMedico(MedicoRequest medicoRequest);
}
