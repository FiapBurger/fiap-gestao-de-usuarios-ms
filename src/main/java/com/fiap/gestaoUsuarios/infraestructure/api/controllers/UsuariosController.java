package com.fiap.gestaoUsuarios.infraestructure.api.controllers;

import com.fiap.gestaoUsuarios.core.ports.in.*;
import com.fiap.gestaoUsuarios.infraestructure.api.requests.MedicoRequest;
import com.fiap.gestaoUsuarios.infraestructure.api.requests.PacienteRequest;
import com.fiap.gestaoUsuarios.infraestructure.api.responses.MedicoResponse;
import com.fiap.gestaoUsuarios.infraestructure.api.responses.PacienteResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private final SalvarPacienteInputPort salvarPacienteInputPort;
    private final EditarPacienteInputPort editarPacienteInputPort;
    private final BuscarPacienteInputPort buscarPacienteInputPort;
    private final DeletarPacienteInputPort deletarPacienteInputPort;
    private final SalvarMedicoInputPort salvarMedicoInputPort;
    private final EditarMedicoInputPort editarMedicoInputPort;
    private final BuscarMedicoInputPort buscarMedicoInputPort;
    private final DeletarMedicoInputPort deletarMedicoInputPort;

    public UsuariosController(SalvarPacienteInputPort salvarPacienteInputPort, EditarPacienteInputPort editarPacienteInputPort, BuscarPacienteInputPort buscarPacienteInputPort, DeletarPacienteInputPort deletarPacienteInputPort, SalvarMedicoInputPort salvarMedicoInputPort, EditarMedicoInputPort editarMedicoInputPort, BuscarMedicoInputPort buscarMedicoInputPort, DeletarMedicoInputPort deletarMedicoInputPort) {
        this.salvarPacienteInputPort = salvarPacienteInputPort;
        this.editarPacienteInputPort = editarPacienteInputPort;
        this.buscarPacienteInputPort = buscarPacienteInputPort;
        this.deletarPacienteInputPort = deletarPacienteInputPort;
        this.salvarMedicoInputPort = salvarMedicoInputPort;
        this.editarMedicoInputPort = editarMedicoInputPort;
        this.buscarMedicoInputPort = buscarMedicoInputPort;
        this.deletarMedicoInputPort = deletarMedicoInputPort;
    }


    @PostMapping("/salvar-paciente")
    public ResponseEntity<Void> salvarPaciente(@Valid @RequestBody PacienteRequest pacienteRequest, UriComponentsBuilder uriComponentsBuilder){
        // TODO validar a criacao do mesmo cliente;
        salvarPacienteInputPort.salvar(pacienteRequest);
        return ResponseEntity.created(uriComponentsBuilder.path("/paciente/{cpf}").buildAndExpand(pacienteRequest.getCpf()).toUri()).build();
    }

    @PatchMapping("/editar-paciente")
    public ResponseEntity<String> editarPaciente(@Valid @RequestBody PacienteRequest pacienteRequest){
        editarPacienteInputPort.editar(pacienteRequest);
        return ResponseEntity.ok("Paciente " + pacienteRequest.getNome() + " atualizado com sucesso!");
    }

   @GetMapping("/buscar-paciente/{cpf}")
    public ResponseEntity<PacienteResponse> buscarPaciente(@PathVariable String cpf){
        var paciente = buscarPacienteInputPort.buscar(cpf);
        return ResponseEntity.ok(paciente);
    }

   @DeleteMapping("/deletar-paciente/{cpf}")
    public ResponseEntity<String> deletarPaciente(@PathVariable String cpf){
       deletarPacienteInputPort.deletar(cpf);
       return ResponseEntity.noContent().build();
   }

    @PostMapping("/salvar-medico")
    public ResponseEntity<Void> salvarMedico(@Valid @RequestBody MedicoRequest medicoRequest, UriComponentsBuilder uriComponentsBuilder){
        // TODO validar a criacao do mesmo cliente;
        salvarMedicoInputPort.salvar(medicoRequest);
        return ResponseEntity.created(uriComponentsBuilder.path("/usuarios/{crm}").buildAndExpand(medicoRequest.getCrm()).toUri()).build();
    }

    @PatchMapping("/editar-medico")
    public ResponseEntity<String> editarMedico(@Valid @RequestBody MedicoRequest medicoRequest){
        editarMedicoInputPort.editar(medicoRequest);
        return ResponseEntity.ok("Medico " + medicoRequest.getNome() + " atualizado com sucesso!");
    }

    @GetMapping("/buscar-medico/{crm}")
    public ResponseEntity<MedicoResponse> buscarMedico(@PathVariable String crm){
        var paciente = buscarMedicoInputPort.buscar(crm);
        return ResponseEntity.ok(paciente);
    }

    @DeleteMapping("/deletar-medico/{crm}")
    public ResponseEntity<String> deletarMedico(@PathVariable String crm){
        deletarMedicoInputPort.deletar(crm);
        return ResponseEntity.noContent().build();
    }


}
