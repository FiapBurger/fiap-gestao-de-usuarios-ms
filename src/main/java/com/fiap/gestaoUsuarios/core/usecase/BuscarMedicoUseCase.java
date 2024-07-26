package com.fiap.gestaoUsuarios.core.usecase;

import com.fiap.gestaoUsuarios.core.ports.in.BuscarMedicoInputPort;
import com.fiap.gestaoUsuarios.core.ports.out.BuscarMedicoOutputPort;
import com.fiap.gestaoUsuarios.infraestructure.api.responses.MedicoResponse;

public class BuscarMedicoUseCase implements BuscarMedicoInputPort {
    private final BuscarMedicoOutputPort buscarMedicoOutputPort;

    public BuscarMedicoUseCase(BuscarMedicoOutputPort buscarMedicoOutputPort) {
        this.buscarMedicoOutputPort = buscarMedicoOutputPort;
    }
    @Override
    public MedicoResponse buscar(String crm) {
        return this.buscarMedicoOutputPort.buscar(crm);
    }
}
