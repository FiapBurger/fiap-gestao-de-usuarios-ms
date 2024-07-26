package com.fiap.gestaoUsuarios.core.domains.entities;

import java.util.Objects;

public class PacienteDTO extends UsuarioDTO {

    private String cpf;

    public PacienteDTO(String nome, String email, String telefone, String endereco, String dataNascimento, String tipoUsuario, String cpf) {
        super(nome, email, telefone, endereco, dataNascimento, tipoUsuario);
        this.cpf = cpf;
    }

    public PacienteDTO(){}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PacienteDTO that = (PacienteDTO) o;
        return Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }
}

