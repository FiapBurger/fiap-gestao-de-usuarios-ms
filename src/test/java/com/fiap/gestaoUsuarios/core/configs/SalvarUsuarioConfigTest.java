package com.fiap.gestaoUsuarios.core.configs;

import com.fiap.gestaoUsuarios.core.usecase.SalvarPacienteUseCase;
import com.fiap.gestaoUsuarios.infraestructure.adapters.SalvarPacienteAdapter;
import com.fiap.gestaoUsuarios.infraestructure.utils.mappers.PacienteMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class SalvarUsuarioConfigTest {
    @Mock
    SalvarPacienteAdapter editarClienteAdapter;
    @Mock
    PacienteMapper pacienteMapper;
    @InjectMocks
    SalvarUsuarioConfig salvarClientConfig;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testEditarClienteUseCaseBean() {

        SalvarPacienteUseCase salvarClienteUseCase = salvarClientConfig.salvarUsuarioUseCase(editarClienteAdapter, pacienteMapper);

        assertNotNull(salvarClienteUseCase, "O bean SalvarClienteUseCase deve ser criado");
    }
}