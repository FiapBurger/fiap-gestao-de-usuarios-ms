package com.fiap.gestaoUsuarios.infraestructure.adapters;

import com.fiap.gestaoUsuarios.core.domains.exception.UsuarioNaoEncontradoException;
import com.fiap.gestaoUsuarios.infraestructure.persistence.entities.PacienteEntity;
import com.fiap.gestaoUsuarios.infraestructure.persistence.repositorys.PacienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class DeletarClienteAdapterTest {

    AutoCloseable openMocks;
    @InjectMocks
    DeletarPacienteAdapter deletarClienteAdapter;
    @Mock
    PacienteRepository pacienteRepository;
    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deveTestarDeletarClienteAdapter(){

        var cpf = "545.464.180-43";
        PacienteEntity cliente = new PacienteEntity();

        when(pacienteRepository.findById(cpf)).thenReturn(Optional.of(cliente));

        deletarClienteAdapter.deletar(cpf);

        verify(pacienteRepository,times(1)).findById(cpf);
        verify(pacienteRepository,times(1)).deleteById(cpf);

    }

    @Test
    public void deveLancarExceptionClienteNaoEncontradoaoDeletarClienteAdapter(){

        when(pacienteRepository.findById(any(String.class))).thenReturn(Optional.empty());

        UsuarioNaoEncontradoException erro = assertThrows(UsuarioNaoEncontradoException.class, ()-> deletarClienteAdapter.deletar(any(String.class)));

        assertNotNull(erro);
    }
}