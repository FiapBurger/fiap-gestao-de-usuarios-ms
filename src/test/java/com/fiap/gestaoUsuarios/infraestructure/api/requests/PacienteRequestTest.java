package com.fiap.gestaoUsuarios.infraestructure.api.requests;

import org.junit.jupiter.api.Test;
import utils.BeanGettersAndSettersTester;

import java.beans.IntrospectionException;



class PacienteRequestTest {
    @Test
    void deveTestarClienteRequest() throws IntrospectionException {
        BeanGettersAndSettersTester.test(PacienteRequest.class);
    }
}