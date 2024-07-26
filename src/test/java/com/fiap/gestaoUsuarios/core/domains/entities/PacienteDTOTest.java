package com.fiap.gestaoUsuarios.core.domains.entities;

import org.junit.jupiter.api.Test;
import utils.BeanGettersAndSettersTester;
import java.beans.IntrospectionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PacienteDTOTest {

    @Test
    public void validaGettersAndSettersClienteDTO() throws IntrospectionException {

        BeanGettersAndSettersTester.test(PacienteDTO.class);
    }
    @Test
    public void deveTestarConstructorClienteDTO(){

        var cpf = "00000000000";
        var email = "joao@email.com.br";
        var nome = "João Guilherme";
        var telefone = "819123456";
        var endereco = "Recife";
        var dataNascimento = "04/06/1997";
        var tipoUsuario = "Paciente";
        PacienteDTO cliente = new PacienteDTO(nome,email,telefone, endereco, dataNascimento, tipoUsuario, cpf);

        assertNotNull(cliente);
        assertEquals(cpf, cliente.getCpf());
        assertEquals(email, cliente.getEmail());
        assertEquals(nome, cliente.getNome());
    }



}