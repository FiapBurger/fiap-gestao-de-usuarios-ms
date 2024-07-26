package com.fiap.gestaoUsuarios.core.usecase;

import com.fiap.gestaoUsuarios.core.domains.entities.PacienteDTO;
import com.fiap.gestaoUsuarios.core.ports.out.SalvarPacienteOutputPort;
import com.fiap.gestaoUsuarios.infraestructure.persistence.entities.PacienteEntity;
import com.fiap.gestaoUsuarios.infraestructure.utils.mappers.PacienteMapper;
import com.fiap.gestaoUsuarios.infraestructure.api.requests.PacienteRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SalvarClienteUseCaseTest {

    @Mock
    SalvarPacienteOutputPort salvarPacienteOutputPort;

    @Mock
    PacienteMapper mapper;

    @Mock
    PacienteEntity pacienteEntity;

    @Mock
    PacienteRequest pacienteRequest;

    @Mock
    PacienteDTO pacienteDTO;

    AutoCloseable mock;
    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
    }
    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Test
    public void deveTestarSalvarClienteUsecase(){

        SalvarPacienteUseCase salvarClienteUseCase = new SalvarPacienteUseCase(salvarPacienteOutputPort,mapper);

        doNothing().when(salvarPacienteOutputPort).salvar(any(PacienteDTO.class));
        when(mapper.toPaciente(any(PacienteRequest.class))).thenReturn(pacienteDTO);
        salvarClienteUseCase.salvar(pacienteRequest);

        verify(salvarPacienteOutputPort,times(1)).salvar(pacienteDTO);
        verify(mapper,times(1)).toPaciente(pacienteRequest);
    }
}