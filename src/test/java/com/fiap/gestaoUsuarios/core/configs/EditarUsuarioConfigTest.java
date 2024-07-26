package com.fiap.gestaoUsuarios.core.configs;

import com.fiap.gestaoUsuarios.core.usecase.EditarPacienteUseCase;
import com.fiap.gestaoUsuarios.infraestructure.adapters.EditarPacienteAdapter;
import com.fiap.gestaoUsuarios.infraestructure.utils.mappers.PacienteMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class EditarUsuarioConfigTest {

    @Mock
    EditarPacienteAdapter editarClienteAdapter;
    @Mock
    PacienteMapper pacienteMapper;
    @InjectMocks
    EditarUsuarioConfig editarClientConfig;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testEditarClienteUseCaseBean() {

        EditarPacienteUseCase editarClienteUseCase = editarClientConfig.editarUsuarioUseCase(editarClienteAdapter, pacienteMapper);

        assertNotNull(editarClienteUseCase, "O bean EditarClienteUseCase deve ser criado");
    }
}