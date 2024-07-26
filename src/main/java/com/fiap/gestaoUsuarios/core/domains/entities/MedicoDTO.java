package com.fiap.gestaoUsuarios.core.domains.entities;

import java.util.Objects;

public class MedicoDTO extends UsuarioDTO {

    private String crm;
    private String especialidade;
    private String experiencia;

    public MedicoDTO(String nome, String email, String telefone, String endereco, String dataNascimento, String tipoUsuario, String crm, String especialidade, String experiencia) {
        super(nome, email, telefone, endereco, dataNascimento, tipoUsuario);
        this.crm = crm;
        this.especialidade = especialidade;
        this.experiencia = experiencia;
    }

    public MedicoDTO(){}

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MedicoDTO medicoDTO = (MedicoDTO) o;
        return Objects.equals(crm, medicoDTO.crm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), crm);
    }

}
