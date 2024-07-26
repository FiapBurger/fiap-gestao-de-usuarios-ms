package com.fiap.gestaoUsuarios.core.usecase;

import com.fiap.gestaoUsuarios.core.ports.in.EditarMedicoInputPort;
import com.fiap.gestaoUsuarios.core.ports.out.EditarMedicoOutputPort;
import com.fiap.gestaoUsuarios.infraestructure.api.requests.MedicoRequest;
import com.fiap.gestaoUsuarios.infraestructure.utils.mappers.MedicoMapper;

public class EditarMedicoUseCase implements EditarMedicoInputPort {

    public final EditarMedicoOutputPort editarMedicoOutputPort;
    private final MedicoMapper medicoMapper;

    public EditarMedicoUseCase(EditarMedicoOutputPort editarMedicoOutputPort, MedicoMapper medicoMapper) {
        this.editarMedicoOutputPort = editarMedicoOutputPort;
        this.medicoMapper = medicoMapper;
    }
    @Override
    public void editar(MedicoRequest medicoRequest) {
        var medico = medicoMapper.toMedico(medicoRequest);
        editarMedicoOutputPort.editar(medico);
    }
}

