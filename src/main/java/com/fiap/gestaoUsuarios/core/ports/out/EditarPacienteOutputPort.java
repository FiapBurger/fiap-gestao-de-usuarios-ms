package com.fiap.gestaoUsuarios.core.ports.out;

import com.fiap.gestaoUsuarios.core.domains.entities.PacienteDTO;

public interface EditarPacienteOutputPort {
    void editar(PacienteDTO paciente);
}
