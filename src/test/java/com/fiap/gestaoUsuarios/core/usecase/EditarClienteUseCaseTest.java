package com.fiap.gestaoUsuarios.core.usecase;

import com.fiap.gestaoUsuarios.core.domains.entities.PacienteDTO;
import com.fiap.gestaoUsuarios.core.ports.out.EditarPacienteOutputPort;
import com.fiap.gestaoUsuarios.infraestructure.api.requests.PacienteRequest;
import com.fiap.gestaoUsuarios.infraestructure.utils.mappers.PacienteMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class EditarClienteUseCaseTest {

    @Mock
    EditarPacienteOutputPort editarPacienteOutputPort;
    @Mock
    private PacienteMapper pacienteMapper;

    @Mock
    private PacienteRequest pacienteRequest;

    @Mock
    private PacienteDTO pacienteDTO;

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
    public void deveTestarEditarClienteUsecase(){

        EditarPacienteUseCase editarClienteUseCase = new EditarPacienteUseCase(editarPacienteOutputPort, pacienteMapper);


        doNothing().when(editarPacienteOutputPort).editar(pacienteDTO);
        when(pacienteMapper.toPaciente(pacienteRequest)).thenReturn(pacienteDTO);
        editarClienteUseCase.editar(pacienteRequest);

        verify(editarPacienteOutputPort,times(1)).editar(pacienteDTO);
        verify(pacienteMapper,times(1)).toPaciente(pacienteRequest);
    }

}