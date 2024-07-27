package com.fiap.gestaoUsuarios.infraestructure.persistence.entities;

import org.junit.jupiter.api.Test;
import utils.BeanGettersAndSettersTester;
import java.beans.IntrospectionException;

class PacienteEntityTest {
    @Test
    public void deveTestarGetersAndSettersClientEntity() throws IntrospectionException {
        BeanGettersAndSettersTester.test(PacienteEntity.class);
    }
}