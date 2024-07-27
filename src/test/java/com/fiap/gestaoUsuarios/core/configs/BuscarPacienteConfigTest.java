package com.fiap.gestaoUsuarios.core.configs;

import com.fiap.gestaoUsuarios.core.usecase.BuscarPacienteUseCase;
import com.fiap.gestaoUsuarios.infraestructure.adapters.BuscarPacienteAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@SpringBootTest
class BuscarPacienteConfigTest {

    @Configuration
    @Import(BuscarPacienteConfig.class)
    static class TestConfig {
        @Bean
        public BuscarPacienteAdapter buscarClienteAdapter() {
            return mock(BuscarPacienteAdapter.class);
        }
    }
    @Autowired
    private BuscarPacienteUseCase buscarClienteUseCase;

    @Test
    public void testBuscarClienteUseCaseBean() {
        assertNotNull(buscarClienteUseCase, "O bean BuscarClienteUseCase deve ser criado");
    }
}