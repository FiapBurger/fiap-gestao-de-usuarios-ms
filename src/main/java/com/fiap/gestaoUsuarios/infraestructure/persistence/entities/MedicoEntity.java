package com.fiap.gestaoUsuarios.infraestructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="medico")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedicoEntity {

    @Id
    @JsonProperty("crm")
    private String crm;

    @JsonProperty("email")
    private String email;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("endereco")
    private String endereco;

    @JsonProperty("dataNascimento")
    private String dataNascimento;

    @JsonProperty("tipoUsuario")
    private String tipoUsuario;

    @JsonProperty("especialidade")
    private String especialidade;

    @JsonProperty("experiencia")
    private String experiencia;

}
