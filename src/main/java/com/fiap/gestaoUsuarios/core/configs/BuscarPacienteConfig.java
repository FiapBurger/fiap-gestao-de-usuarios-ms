package com.fiap.gestaoUsuarios.core.configs;

import com.fiap.gestaoUsuarios.core.usecase.BuscarPacienteUseCase;
import com.fiap.gestaoUsuarios.infraestructure.adapters.BuscarPacienteAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarPacienteConfig {
    
    @Bean
    public BuscarPacienteUseCase buscarUsuarioUseCase(BuscarPacienteAdapter buscarUsuarioAdapter){
        return new BuscarPacienteUseCase(buscarUsuarioAdapter);
    }
}


