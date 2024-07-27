package com.fiap.gestaoUsuarios.core.ports.in;

import com.fiap.gestaoUsuarios.infraestructure.api.responses.MedicoResponse;

public interface BuscarMedicoInputPort {
    MedicoResponse buscar(String crm);
}
