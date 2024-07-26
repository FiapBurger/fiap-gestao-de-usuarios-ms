package com.fiap.gestaoUsuarios.infraestructure.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;


public class MedicoResponse {

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
