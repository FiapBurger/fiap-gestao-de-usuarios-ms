package com.fiap.gestaoUsuarios.core.configs;

import com.fiap.gestaoUsuarios.core.usecase.DeletarPacienteUseCase;
import com.fiap.gestaoUsuarios.infraestructure.adapters.DeletarPacienteAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

@SpringBootTest(classes = {DeletarUsuarioConfigTest.TestConfig.class, DeletarUsuarioConfig.class})
public class DeletarUsuarioConfigTest {
    @Configuration
    static class TestConfig {
        @Bean
        public DeletarPacienteAdapter deletarClienteAdapter() {
            return mock(DeletarPacienteAdapter.class);
        }
    }
    @Autowired
    private DeletarPacienteUseCase deletarClienteUseCase;
    @Test
    public void testDeletarClienteUseCaseBean() {
        assertNotNull(deletarClienteUseCase, "O bean DeletarClienteUseCase deve ser criado");
    }
}