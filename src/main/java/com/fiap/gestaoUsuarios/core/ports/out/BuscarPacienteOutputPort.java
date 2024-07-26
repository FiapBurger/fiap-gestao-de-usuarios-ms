package com.fiap.gestaoUsuarios.core.ports.out;

import com.fiap.gestaoUsuarios.infraestructure.api.responses.PacienteResponse;

public interface BuscarPacienteOutputPort {

    PacienteResponse buscar (String cpf);
}
