package com.fiap.gestaoUsuarios.core.usecase;

import com.fiap.gestaoUsuarios.core.ports.in.SalvarPacienteInputPort;
import com.fiap.gestaoUsuarios.core.ports.out.SalvarPacienteOutputPort;
import com.fiap.gestaoUsuarios.infraestructure.api.requests.PacienteRequest;
import com.fiap.gestaoUsuarios.infraestructure.utils.mappers.PacienteMapper;

public class SalvarPacienteUseCase implements SalvarPacienteInputPort {

    private final SalvarPacienteOutputPort salvarPacienteOutputPort;
    private final PacienteMapper usuarioMapper;
    public SalvarPacienteUseCase(SalvarPacienteOutputPort salvarPacienteOutputPort, PacienteMapper usuarioMapper) {
        this.salvarPacienteOutputPort = salvarPacienteOutputPort;
        this.usuarioMapper = usuarioMapper;
    }
    @Override
    public void salvar(PacienteRequest usuarioRequest) {
        var usuario = usuarioMapper.toPaciente(usuarioRequest);
        salvarPacienteOutputPort.salvar(usuario);
    }
}
