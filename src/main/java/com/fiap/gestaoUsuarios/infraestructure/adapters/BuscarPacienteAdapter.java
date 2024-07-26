package com.fiap.gestaoUsuarios.infraestructure.adapters;

import com.fiap.gestaoUsuarios.core.domains.exception.UsuarioNaoEncontradoException;
import com.fiap.gestaoUsuarios.core.domains.exception.ExceptionsMessageEnum;
import com.fiap.gestaoUsuarios.core.ports.out.BuscarPacienteOutputPort;
import com.fiap.gestaoUsuarios.infraestructure.api.responses.PacienteResponse;
import com.fiap.gestaoUsuarios.infraestructure.utils.mappers.PacienteMapper;
import com.fiap.gestaoUsuarios.infraestructure.persistence.entities.PacienteEntity;
import com.fiap.gestaoUsuarios.infraestructure.persistence.repositorys.PacienteRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BuscarPacienteAdapter implements BuscarPacienteOutputPort {
    private final PacienteRepository pacienteRepository;
    private final PacienteMapper usuarioMapper;

    public BuscarPacienteAdapter(PacienteRepository pacienteRepository, PacienteMapper usuarioMapper) {
        this.pacienteRepository = pacienteRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public PacienteResponse buscar(String cpf) {

        Optional<PacienteEntity> paciente = pacienteRepository.findById(cpf);

        if(paciente.isPresent()){
            return usuarioMapper.toPacienteResponse(paciente.get());
        }else{
            throw new UsuarioNaoEncontradoException(ExceptionsMessageEnum.USUARIO_NAO_ENCONTRADO.value());
        }
    }
}
