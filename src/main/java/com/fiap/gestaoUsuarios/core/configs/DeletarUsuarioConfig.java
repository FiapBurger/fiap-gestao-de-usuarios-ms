package com.fiap.gestaoUsuarios.core.configs;

import com.fiap.gestaoUsuarios.core.usecase.DeletarPacienteUseCase;
import com.fiap.gestaoUsuarios.infraestructure.adapters.DeletarPacienteAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarUsuarioConfig {
    @Bean
    public DeletarPacienteUseCase deletarUsuarioUseCase(DeletarPacienteAdapter deletarUsuarioAdapter){
        return new DeletarPacienteUseCase(deletarUsuarioAdapter);
    }
}
