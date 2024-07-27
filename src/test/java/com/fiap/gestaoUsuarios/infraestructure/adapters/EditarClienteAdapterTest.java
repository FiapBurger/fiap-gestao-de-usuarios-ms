package com.fiap.gestaoUsuarios.infraestructure.adapters;

import com.fiap.gestaoUsuarios.core.domains.entities.PacienteDTO;
import com.fiap.gestaoUsuarios.core.domains.exception.UsuarioNaoEncontradoException;
import com.fiap.gestaoUsuarios.infraestructure.persistence.entities.PacienteEntity;
import com.fiap.gestaoUsuarios.infraestructure.persistence.repositorys.PacienteRepository;
import com.fiap.gestaoUsuarios.infraestructure.utils.mappers.PacienteMapper;
import org.junit.jupiter.api.AfterEach;
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

class EditarClienteAdapterTest {

    AutoCloseable openMocks;
    @InjectMocks
    EditarPacienteAdapter editarClienteAdapter;
    @Mock
    PacienteRepository pacienteRepository;
    @Mock
    PacienteEntity pacienteEntity;
    @Mock
    PacienteMapper pacienteMapper;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
    }
    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    public void deveTestarEditarCliente(){

        var cpf     = "545.464.180-43";
        var email   = "teste@gmail.com";
        var nome    = "Teste Souza Silva";
        var telefone = "819123456";
        var endereco = "Recife";
        var dataNascimento = "04/06/1997";
        var tipoUsuario = "Paciente";

        PacienteDTO pacienteDTO = new PacienteDTO(nome,email,telefone, endereco, dataNascimento, tipoUsuario, cpf);;

        when(pacienteRepository.findById(any(String.class))).thenReturn(Optional.of(pacienteEntity));
        when(pacienteMapper.toPacienteEntity(any(PacienteDTO.class))).thenReturn(pacienteEntity);

        editarClienteAdapter.editar(pacienteDTO);

        verify(pacienteRepository, times(1)).findById(any(String.class));
        verify(pacienteRepository, times(1)).save(any(PacienteEntity.class));
    }

    @Test
    public void deveDispararExceptionAoTestarEditarCliente(){

        var cpf     = "545.464.180-43";
        var email   = "teste@gmail.com";
        var nome    = "Teste Souza Silva";
        var telefone = "819123456";
        var endereco = "Recife";
        var dataNascimento = "04/06/1997";
        var tipoUsuario = "Paciente";

        PacienteDTO pacienteDTO = new PacienteDTO(nome,email,telefone, endereco, dataNascimento, tipoUsuario, cpf);;

        when(pacienteRepository.findById(any(String.class))).thenReturn(Optional.empty());

        UsuarioNaoEncontradoException erro = assertThrows(UsuarioNaoEncontradoException.class, ()-> editarClienteAdapter.editar(pacienteDTO));

        assertNotNull(erro);
    }
}