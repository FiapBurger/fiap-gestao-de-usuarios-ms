package com.fiap.gestaoUsuarios.core.ports.out;


import com.fiap.gestaoUsuarios.core.domains.entities.MedicoDTO;

public interface EditarMedicoOutputPort {
    void editar(MedicoDTO medico);
}
