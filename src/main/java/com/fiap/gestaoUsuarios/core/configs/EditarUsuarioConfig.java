package com.fiap.gestaoUsuarios.core.configs;

import com.fiap.gestaoUsuarios.core.usecase.EditarPacienteUseCase;
import com.fiap.gestaoUsuarios.infraestructure.adapters.EditarPacienteAdapter;
import com.fiap.gestaoUsuarios.infraestructure.utils.mappers.PacienteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EditarUsuarioConfig {
    @Bean
    public EditarPacienteUseCase editarUsuarioUseCase(EditarPacienteAdapter editarUsuarioAdapter, PacienteMapper usuarioMapper){
        return new EditarPacienteUseCase(editarUsuarioAdapter, usuarioMapper);
    }
}
