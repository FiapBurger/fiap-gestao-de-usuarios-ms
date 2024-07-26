package com.fiap.gestaoUsuarios.infraestructure.adapters;

import com.fiap.gestaoUsuarios.core.domains.entities.PacienteDTO;
import com.fiap.gestaoUsuarios.core.ports.out.SalvarPacienteOutputPort;
import com.fiap.gestaoUsuarios.infraestructure.persistence.entities.PacienteEntity;
import com.fiap.gestaoUsuarios.infraestructure.persistence.repositorys.PacienteRepository;
import com.fiap.gestaoUsuarios.infraestructure.utils.mappers.PacienteMapper;
import org.springframework.stereotype.Component;

@Component
public class SalvarPacienteAdapter implements SalvarPacienteOutputPort {
    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;
    public SalvarPacienteAdapter(PacienteRepository pacienteRepository, PacienteMapper pacienteMapper){
        this.pacienteRepository = pacienteRepository;
        this.pacienteMapper = pacienteMapper;
    }
    @Override
    public void salvar(PacienteDTO paciente) {

        PacienteEntity pacienteEntity = pacienteMapper.toPacienteEntity(paciente);
        pacienteRepository.save(pacienteEntity);
    }
}
