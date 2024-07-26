package com.fiap.gestaoUsuarios.core.ports.out;

import com.fiap.gestaoUsuarios.core.domains.entities.PacienteDTO;

public interface SalvarPacienteOutputPort {
    void salvar(PacienteDTO paciente);
}
