package com.fiap.gestaoUsuarios.core.usecase;

import com.fiap.gestaoUsuarios.core.ports.in.SalvarMedicoInputPort;
import com.fiap.gestaoUsuarios.core.ports.out.SalvarMedicoOutputPort;
import com.fiap.gestaoUsuarios.infraestructure.api.requests.MedicoRequest;
import com.fiap.gestaoUsuarios.infraestructure.utils.mappers.MedicoMapper;

public class SalvarMedicoUseCase implements SalvarMedicoInputPort{

    private final SalvarMedicoOutputPort salvarMedicoOutputPort;

    private final MedicoMapper medicoMapper;

    public SalvarMedicoUseCase(SalvarMedicoOutputPort salvarMedicoOutputPort, MedicoMapper medicoMapper) {
        this.salvarMedicoOutputPort = salvarMedicoOutputPort;
        this.medicoMapper = medicoMapper;
    }
    @Override
    public void salvar(MedicoRequest medicoRequest) {
        var usuario = medicoMapper.toMedico(medicoRequest);
        salvarMedicoOutputPort.salvar(usuario);
    }
}
