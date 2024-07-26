package com.fiap.gestaoUsuarios.infraestructure.adapters;

import com.fiap.gestaoUsuarios.core.domains.exception.ExceptionsMessageEnum;
import com.fiap.gestaoUsuarios.core.domains.exception.UsuarioNaoEncontradoException;
import com.fiap.gestaoUsuarios.core.ports.out.DeletarMedicoOutputPort;
import com.fiap.gestaoUsuarios.infraestructure.persistence.entities.MedicoEntity;
import com.fiap.gestaoUsuarios.infraestructure.persistence.repositorys.MedicoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeletarMedicoAdapter implements DeletarMedicoOutputPort {

    private final MedicoRepository medicoeRepository;

    public DeletarMedicoAdapter(MedicoRepository medicoeRepository){
        this.medicoeRepository = medicoeRepository;
    }

    @Override
    public void deletar(String crm) {
        Optional<MedicoEntity> medico = medicoeRepository.findById(crm);

        if(medico.isPresent()){
            medicoeRepository.deleteById(crm);
        }else{
            throw new UsuarioNaoEncontradoException(ExceptionsMessageEnum.USUARIO_NAO_ENCONTRADO.value());
        }
    }
}
