package com.fiap.gestaoUsuarios.infraestructure.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.gestaoUsuarios.core.ports.in.*;
import com.fiap.gestaoUsuarios.infraestructure.api.requests.PacienteRequest;
import com.fiap.gestaoUsuarios.infraestructure.api.responses.PacienteResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriComponentsBuilder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class UsuariosControllerTest {
    AutoCloseable openMocks;
    @Mock
    private SalvarPacienteInputPort salvarPacienteInputport;
    @Mock
    private EditarPacienteInputPort editarPacienteInputport;
    @Mock
    private BuscarPacienteInputPort buscarPacienteInputPort;
    @Mock
    private DeletarPacienteInputPort deletarPacienteInputPort;
    @Mock
    private SalvarMedicoInputPort salvarMedicoInputPort;
    @Mock
    private EditarMedicoInputPort editarMedicoInputPort;
    @Mock
    private BuscarMedicoInputPort buscarMedicoInputPort;
    @Mock
    private DeletarMedicoInputPort deletarMedicoInputPort;
    @Mock
    private MockMvc mockMvc;
    @Mock
    private PacienteRequest pacienteRequest;
    @Mock
    PacienteResponse pacienteResponse;
    @Mock
    UriComponentsBuilder uriComponentsBuilder;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        UsuariosController controller = new UsuariosController(salvarPacienteInputport, editarPacienteInputport,
                buscarPacienteInputPort, deletarPacienteInputPort,salvarMedicoInputPort,editarMedicoInputPort,buscarMedicoInputPort,deletarMedicoInputPort);
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }
    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }
    @Test
    void salvar() throws Exception {

        doNothing().when(salvarPacienteInputport).salvar(any(PacienteRequest.class));

        mockMvc.perform(post("/usuarios/salvar-paciente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(pacienteRequest)))
                .andExpect(status().isCreated());

        verify(salvarPacienteInputport, times(1)).salvar(any(PacienteRequest.class));

    }

    @Test
    void editar() throws Exception {

        doNothing().when(editarPacienteInputport).editar(any(PacienteRequest.class));

        mockMvc.perform(patch("/usuarios/editar-paciente")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(pacienteRequest)))
                    .andExpect(status().isOk());

        verify(editarPacienteInputport, times(1)).editar(any(PacienteRequest.class));

    }

    @Test
    void buscar() throws Exception {
        String cpf = "476.724.180-41";
        when(buscarPacienteInputPort.buscar(any(String.class))).thenReturn(pacienteResponse);

        mockMvc.perform(get("/usuarios/buscar-paciente/{cpf}", cpf))
                    .andExpect(status().isOk());

        verify(buscarPacienteInputPort, times(1)).buscar(any(String.class));

    }

    @Test
    void deletar() throws Exception {

        String cpf = "476.724.180-41";
        doNothing().when(deletarPacienteInputPort).deletar(cpf);

        mockMvc.perform(delete("/usuarios/deletar-paciente/{cpf}", cpf))
                    .andExpect(status().isNoContent());

        verify(deletarPacienteInputPort, times(1)).deletar(cpf);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}