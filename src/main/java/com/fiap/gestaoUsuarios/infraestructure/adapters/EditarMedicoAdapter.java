package com.fiap.gestaoUsuarios.infraestructure.adapters;

import com.fiap.gestaoUsuarios.core.domains.entities.MedicoDTO;
import com.fiap.gestaoUsuarios.core.domains.exception.ExceptionsMessageEnum;
import com.fiap.gestaoUsuarios.core.domains.exception.UsuarioNaoEncontradoException;
import com.fiap.gestaoUsuarios.core.ports.out.EditarMedicoOutputPort;
import com.fiap.gestaoUsuarios.infraestructure.persistence.entities.MedicoEntity;
import com.fiap.gestaoUsuarios.infraestructure.persistence.repositorys.MedicoRepository;
import com.fiap.gestaoUsuarios.infraestructure.utils.mappers.MedicoMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EditarMedicoAdapter implements EditarMedicoOutputPort {

    private final MedicoRepository medicoRepository;

    private final MedicoMapper medicoMapper;

    public EditarMedicoAdapter(MedicoRepository pacienteRepository, MedicoMapper medicoMapper){
        this.medicoRepository = pacienteRepository;
        this.medicoMapper = medicoMapper;
    }

    @Override
    public void editar(MedicoDTO medico) {
        Optional<MedicoEntity> medicoEntity = medicoRepository.findById(medico.getCrm());
        if(medicoEntity.isPresent()){

            medicoMapper.toMedicoEntity(medico);

            medicoRepository.save(medicoEntity.get());
        }else{

            throw new UsuarioNaoEncontradoException(ExceptionsMessageEnum.USUARIO_NAO_ENCONTRADO.value());
        }
    }
}
