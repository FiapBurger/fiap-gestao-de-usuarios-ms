package com.fiap.gestaoUsuarios.core.ports.in;

import com.fiap.gestaoUsuarios.infraestructure.api.requests.PacienteRequest;

public interface SalvarPacienteInputPort {
    void salvar(PacienteRequest paciente);
}
