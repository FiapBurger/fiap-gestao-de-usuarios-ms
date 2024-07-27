package com.fiap.gestaoUsuarios.core.ports.in;

import com.fiap.gestaoUsuarios.infraestructure.api.requests.MedicoRequest;

public interface EditarMedicoInputPort {
    void editar(MedicoRequest medicoRequest);
}
