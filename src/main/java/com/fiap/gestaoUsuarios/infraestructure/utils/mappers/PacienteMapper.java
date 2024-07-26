package com.fiap.gestaoUsuarios.infraestructure.utils.mappers;


import com.fiap.gestaoUsuarios.core.domains.entities.PacienteDTO;
import com.fiap.gestaoUsuarios.infraestructure.api.requests.PacienteRequest;
import com.fiap.gestaoUsuarios.infraestructure.api.responses.PacienteResponse;
import com.fiap.gestaoUsuarios.infraestructure.persistence.entities.PacienteEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PacienteMapper {
    PacienteDTO toPaciente(PacienteRequest pacienteRequest);
    PacienteResponse toPacienteResponse(PacienteEntity pacienteEntity);
    PacienteEntity toPacienteEntity(PacienteDTO pacienteDTO);
}
