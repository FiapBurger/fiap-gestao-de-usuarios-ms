package com.fiap.gestaoUsuarios.infraestructure.adapters;

import com.fiap.gestaoUsuarios.core.domains.entities.PacienteDTO;
import com.fiap.gestaoUsuarios.infraestructure.persistence.entities.PacienteEntity;

import com.fiap.gestaoUsuarios.infraestructure.persistence.repositorys.PacienteRepository;
import com.fiap.gestaoUsuarios.infraestructure.utils.mappers.PacienteMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SalvarClienteAdapterTest {

    AutoCloseable openMocks;
    @InjectMocks
    SalvarPacienteAdapter salvarClienteAdapter;
    @Mock
    PacienteRepository pacienteRepository;
    @Mock
    PacienteMapper pacienteMapper;
    @Mock
    PacienteDTO pacienteDTO;
    @Mock
    PacienteEntity pacienteEntity;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
    }
    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    public void deveTestarSalvarCliente(){


        when(pacienteRepository.save(any(PacienteEntity.class))).thenReturn(pacienteEntity);
        when(pacienteMapper.toPacienteEntity(any(PacienteDTO.class))).thenReturn(pacienteEntity);

        salvarClienteAdapter.salvar(pacienteDTO);

        verify(pacienteMapper, times(1)).toPacienteEntity(pacienteDTO);
        verify(pacienteRepository, times(1)).save(any(PacienteEntity.class));
    }
}