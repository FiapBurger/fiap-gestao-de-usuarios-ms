package com.fiap.gestaoUsuarios.core.usecase;

import com.fiap.gestaoUsuarios.core.ports.in.DeletarMedicoInputPort;
import com.fiap.gestaoUsuarios.core.ports.out.DeletarMedicoOutputPort;

public class DeletarMedicoUseCase implements DeletarMedicoInputPort {

    private final DeletarMedicoOutputPort deletarMedicoOutputPort;

    public DeletarMedicoUseCase(DeletarMedicoOutputPort deletarMedicoOutputPort) {
        this.deletarMedicoOutputPort = deletarMedicoOutputPort;
    }

    @Override
    public void deletar(String crm) {
        deletarMedicoOutputPort.deletar(crm);
    }
}
