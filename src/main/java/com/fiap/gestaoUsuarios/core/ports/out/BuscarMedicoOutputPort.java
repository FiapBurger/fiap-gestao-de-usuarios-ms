package com.fiap.gestaoUsuarios.core.ports.out;

import com.fiap.gestaoUsuarios.infraestructure.api.responses.MedicoResponse;

public interface BuscarMedicoOutputPort {
    MedicoResponse buscar (String crm);
}
