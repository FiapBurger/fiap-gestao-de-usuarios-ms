package com.fiap.gestaoUsuarios.core.ports.in;


import com.fiap.gestaoUsuarios.infraestructure.api.responses.PacienteResponse;

public interface BuscarPacienteInputPort {
    PacienteResponse buscar(String cpf);
}
