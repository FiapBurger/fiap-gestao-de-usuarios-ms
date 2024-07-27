package com.fiap.gestaoUsuarios.core.usecase;

import com.fiap.gestaoUsuarios.core.ports.in.DeletarPacienteInputPort;
import com.fiap.gestaoUsuarios.core.ports.out.DeletarPacienteOutputPort;

public class DeletarPacienteUseCase implements DeletarPacienteInputPort {

    private final DeletarPacienteOutputPort deletarPacienteOutputPort;

    public DeletarPacienteUseCase(DeletarPacienteOutputPort deletarPacienteOutputPort) {
        this.deletarPacienteOutputPort = deletarPacienteOutputPort;
    }

    @Override
    public void deletar(String id) {
        deletarPacienteOutputPort.deletar(id);
    }
}
