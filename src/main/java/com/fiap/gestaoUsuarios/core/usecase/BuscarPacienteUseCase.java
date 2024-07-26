
package com.fiap.gestaoUsuarios.core.usecase;

import com.fiap.gestaoUsuarios.core.ports.in.BuscarPacienteInputPort;
import com.fiap.gestaoUsuarios.core.ports.out.BuscarPacienteOutputPort;
import com.fiap.gestaoUsuarios.infraestructure.api.responses.PacienteResponse;

public class BuscarPacienteUseCase implements BuscarPacienteInputPort {
    private final BuscarPacienteOutputPort buscarPacienteOutputPort;
    public BuscarPacienteUseCase(BuscarPacienteOutputPort buscarPacienteOutputPort) {
        this.buscarPacienteOutputPort = buscarPacienteOutputPort;
    }
    @Override
    public PacienteResponse buscar(String id) {
        return this.buscarPacienteOutputPort.buscar(id);
    }
}

