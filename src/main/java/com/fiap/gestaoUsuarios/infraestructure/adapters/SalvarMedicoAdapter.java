package com.fiap.gestaoUsuarios.infraestructure.adapters;

import com.fiap.gestaoUsuarios.core.domains.entities.MedicoDTO;
import com.fiap.gestaoUsuarios.core.ports.out.SalvarMedicoOutputPort;
import com.fiap.gestaoUsuarios.infraestructure.persistence.entities.MedicoEntity;
import com.fiap.gestaoUsuarios.infraestructure.persistence.repositorys.MedicoRepository;
import com.fiap.gestaoUsuarios.infraestructure.utils.mappers.MedicoMapper;
import org.springframework.stereotype.Component;

@Component
public class SalvarMedicoAdapter implements SalvarMedicoOutputPort {

    private final MedicoRepository medicoRepository;
    private final MedicoMapper medicoMapper;

    public SalvarMedicoAdapter(MedicoRepository medicoRepository, MedicoMapper medicoMapper){
        this.medicoRepository = medicoRepository;
        this.medicoMapper = medicoMapper;
    }
    @Override
    public void salvar(MedicoDTO medico) {

        MedicoEntity medicoEntity = medicoMapper.toMedicoEntity(medico);
        medicoRepository.save(medicoEntity);
    }
}
