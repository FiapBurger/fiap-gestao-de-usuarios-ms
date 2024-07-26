package com.fiap.gestaoUsuarios.core.usecase;

import com.fiap.gestaoUsuarios.core.ports.out.BuscarPacienteOutputPort;
import com.fiap.gestaoUsuarios.infraestructure.api.responses.PacienteResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class BuscarClienteUseCaseTest {

    @Mock
    BuscarPacienteOutputPort buscarPacienteOutputPort;
    @Mock
    private PacienteResponse pacienteResponse;
    AutoCloseable mock;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void deveTestarBuscarClienteUsecase(){

        BuscarPacienteUseCase buscarClienteUseCase = new BuscarPacienteUseCase(buscarPacienteOutputPort);
        var cpf = "545.464.180-43";
        when(buscarPacienteOutputPort.buscar(any(String.class))).thenReturn(pacienteResponse);
        PacienteResponse response = buscarClienteUseCase.buscar(cpf);
        assertNotNull(response);
        assertInstanceOf(PacienteResponse.class, pacienteResponse);

    }
}