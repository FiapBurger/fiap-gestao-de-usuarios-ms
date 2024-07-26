package com.fiap.gestaoUsuarios.core.usecase;

import com.fiap.gestaoUsuarios.core.ports.in.EditarPacienteInputPort;
import com.fiap.gestaoUsuarios.core.ports.out.EditarPacienteOutputPort;
import com.fiap.gestaoUsuarios.infraestructure.utils.mappers.PacienteMapper;
import com.fiap.gestaoUsuarios.infraestructure.api.requests.PacienteRequest;

public class EditarPacienteUseCase implements EditarPacienteInputPort {
    public final EditarPacienteOutputPort editarPacienteOutputPort;
    private final PacienteMapper usuarioMapper;
    public EditarPacienteUseCase(EditarPacienteOutputPort editarPacienteOutputPort, PacienteMapper usuarioMapper) {
        this.editarPacienteOutputPort = editarPacienteOutputPort;
        this.usuarioMapper = usuarioMapper;
    }
    @Override
    public void editar(PacienteRequest usuarioRequest) {
        var usuario = usuarioMapper.toPaciente(usuarioRequest);
        editarPacienteOutputPort.editar(usuario);
    }
}
