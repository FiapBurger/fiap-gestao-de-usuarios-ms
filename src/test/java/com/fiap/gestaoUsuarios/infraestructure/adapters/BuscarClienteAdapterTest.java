package com.fiap.gestaoUsuarios.infraestructure.adapters;

import com.fiap.gestaoUsuarios.core.domains.exception.UsuarioNaoEncontradoException;
import com.fiap.gestaoUsuarios.infraestructure.api.responses.PacienteResponse;
import com.fiap.gestaoUsuarios.infraestructure.persistence.entities.PacienteEntity;
import com.fiap.gestaoUsuarios.infraestructure.utils.mappers.PacienteMapper;
import com.fiap.gestaoUsuarios.infraestructure.persistence.repositorys.PacienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class BuscarClienteAdapterTest {
    AutoCloseable openMocks;
    @InjectMocks
    BuscarPacienteAdapter buscarClienteAdapter;
    @Mock
    PacienteRepository pacienteRepository;
    @Mock
    PacienteMapper pacienteMapper;
    @Mock
    PacienteEntity entity;
    @Mock
    PacienteResponse pacienteResponse;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deveTestarBuscarClienteAdapter(){

        var cpf = "545.464.180-43";

        when(pacienteRepository.findById(any(String.class))).thenReturn(Optional.of(entity));
        when(pacienteMapper.toPacienteResponse(any(PacienteEntity.class))).thenReturn(pacienteResponse);

        var cliente = buscarClienteAdapter.buscar(cpf);

        assertNotNull(cliente);
        assertInstanceOf(PacienteResponse.class, cliente);
    }

    @Test
    public void deveLancarExceptionClienteNaoEncontradoNoBuscarClienteAdapter(){

        var cpf = "545.464.180-43";

        when(pacienteRepository.findById(any(String.class))).thenReturn(Optional.empty());

        UsuarioNaoEncontradoException erro = assertThrows(UsuarioNaoEncontradoException.class, ()-> buscarClienteAdapter.buscar(cpf));

        assertNotNull(erro);

    }
}