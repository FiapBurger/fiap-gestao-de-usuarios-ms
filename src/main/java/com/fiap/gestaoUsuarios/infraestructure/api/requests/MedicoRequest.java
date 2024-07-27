package com.fiap.gestaoUsuarios.infraestructure.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MedicoRequest {

    @NotBlank(message = "CRM não pode ser vazio!")
    @JsonProperty("crm")
    private String crm;

    @NotBlank(message = "Email não pode ser vazio!")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "Nome não pode ser vazio!")
    @JsonProperty("nome")
    private String nome;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("endereco")
    private String endereco;

    @JsonProperty("dataNascimento")
    private String dataNascimento;

    @NotBlank(message = "tipoUsuario não pode ser vazio!")
    @JsonProperty("tipoUsuario")
    private String tipoUsuario;

    @NotBlank(message = "especialidade não pode ser vazio!")
    @JsonProperty("especialidade")
    private String especialidade;

    @NotBlank(message = "experiencia não pode ser vazio!")
    @JsonProperty("experiencia")
    private String experiencia;
}
