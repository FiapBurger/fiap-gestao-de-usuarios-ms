package com.fiap.gestaoUsuarios.core.ports.in;

import com.fiap.gestaoUsuarios.infraestructure.api.requests.MedicoRequest;

public interface SalvarMedicoInputPort {
    void salvar(MedicoRequest medico);
}
