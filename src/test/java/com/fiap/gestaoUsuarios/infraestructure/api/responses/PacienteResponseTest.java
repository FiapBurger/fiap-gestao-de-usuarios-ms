package com.fiap.gestaoUsuarios.infraestructure.api.responses;

import org.junit.jupiter.api.Test;
import utils.BeanGettersAndSettersTester;
import java.beans.IntrospectionException;
class PacienteResponseTest {
    @Test
    public void deveteTestarClienteResponseTest() throws IntrospectionException {
        BeanGettersAndSettersTester.test(PacienteResponse.class);
    }

}