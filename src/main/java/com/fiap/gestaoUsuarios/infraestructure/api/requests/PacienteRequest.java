package com.fiap.gestaoUsuarios.infraestructure.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PacienteRequest {

    @NotBlank(message = "CPF não pode ser vazio!")
    @JsonProperty("cpf")
    private String cpf;

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
}
