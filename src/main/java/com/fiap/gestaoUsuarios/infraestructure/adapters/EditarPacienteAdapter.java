package com.fiap.gestaoUsuarios.infraestructure.adapters;

import com.fiap.gestaoUsuarios.core.domains.entities.PacienteDTO;
import com.fiap.gestaoUsuarios.core.domains.exception.UsuarioNaoEncontradoException;
import com.fiap.gestaoUsuarios.core.domains.exception.ExceptionsMessageEnum;
import com.fiap.gestaoUsuarios.core.ports.out.EditarPacienteOutputPort;
import com.fiap.gestaoUsuarios.infraestructure.persistence.entities.PacienteEntity;
import com.fiap.gestaoUsuarios.infraestructure.persistence.repositorys.PacienteRepository;
import com.fiap.gestaoUsuarios.infraestructure.utils.mappers.PacienteMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EditarPacienteAdapter implements EditarPacienteOutputPort {

    private final PacienteRepository pacienteRepository;

    private final PacienteMapper pacienteMapper;

    public EditarPacienteAdapter(PacienteRepository pacienteRepository, PacienteMapper pacienteMapper){
        this.pacienteRepository = pacienteRepository;
        this.pacienteMapper = pacienteMapper;
    }

    @Override
    public void editar(PacienteDTO paciente) {
        Optional<PacienteEntity> pacienteEntity = pacienteRepository.findById(paciente.getCpf());
        if(pacienteEntity.isPresent()){

            PacienteEntity pacienteEntityToUpdate = pacienteMapper.toPacienteEntity(paciente);
            pacienteRepository.save(pacienteEntityToUpdate);
        }else{

            throw new UsuarioNaoEncontradoException(ExceptionsMessageEnum.USUARIO_NAO_ENCONTRADO.value());
        }
    }
}
