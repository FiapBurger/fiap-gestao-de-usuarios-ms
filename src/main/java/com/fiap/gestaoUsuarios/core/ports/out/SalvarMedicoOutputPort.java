package com.fiap.gestaoUsuarios.core.ports.out;

import com.fiap.gestaoUsuarios.core.domains.entities.MedicoDTO;

public interface SalvarMedicoOutputPort {
    void salvar(MedicoDTO medico);
}
