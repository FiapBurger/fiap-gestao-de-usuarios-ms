package com.fiap.gestaoUsuarios.infraestructure.adapters;

import com.fiap.gestaoUsuarios.core.domains.exception.ExceptionsMessageEnum;
import com.fiap.gestaoUsuarios.core.domains.exception.UsuarioNaoEncontradoException;
import com.fiap.gestaoUsuarios.core.ports.out.BuscarMedicoOutputPort;
import com.fiap.gestaoUsuarios.infraestructure.api.responses.MedicoResponse;
import com.fiap.gestaoUsuarios.infraestructure.persistence.entities.MedicoEntity;
import com.fiap.gestaoUsuarios.infraestructure.persistence.repositorys.MedicoRepository;
import com.fiap.gestaoUsuarios.infraestructure.utils.mappers.MedicoMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BuscarMedicoAdapter implements BuscarMedicoOutputPort {

    private final MedicoRepository medicoRepository;
    private final MedicoMapper medicoMapper;

    public BuscarMedicoAdapter(MedicoRepository medicoRepository, MedicoMapper medicoMapper) {
        this.medicoRepository = medicoRepository;
        this.medicoMapper = medicoMapper;
    }

    @Override
    public MedicoResponse buscar(String id) {

        Optional<MedicoEntity> medico = medicoRepository.findById(id);

        if(medico.isPresent()){
            return medicoMapper.toMedicoResponse(medico.get());
        }else{
            throw new UsuarioNaoEncontradoException(ExceptionsMessageEnum.USUARIO_NAO_ENCONTRADO.value());
        }
    }
}
