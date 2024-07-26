package com.fiap.gestaoUsuarios.infraestructure.adapters;

import com.fiap.gestaoUsuarios.core.domains.exception.UsuarioNaoEncontradoException;
import com.fiap.gestaoUsuarios.core.domains.exception.ExceptionsMessageEnum;
import com.fiap.gestaoUsuarios.core.ports.out.DeletarPacienteOutputPort;
import com.fiap.gestaoUsuarios.infraestructure.persistence.entities.PacienteEntity;
import com.fiap.gestaoUsuarios.infraestructure.persistence.repositorys.PacienteRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class DeletarPacienteAdapter implements DeletarPacienteOutputPort {
    private final PacienteRepository pacienteRepository;

    public DeletarPacienteAdapter(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public void deletar(String id) {
        Optional<PacienteEntity> paciente = pacienteRepository.findById(id);

        if(paciente.isPresent()){
            pacienteRepository.deleteById(id);
        }else{
            throw new UsuarioNaoEncontradoException(ExceptionsMessageEnum.USUARIO_NAO_ENCONTRADO.value());
        }
    }
}
