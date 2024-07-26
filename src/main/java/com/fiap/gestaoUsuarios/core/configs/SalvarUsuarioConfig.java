package com.fiap.gestaoUsuarios.core.configs;

import com.fiap.gestaoUsuarios.core.usecase.SalvarPacienteUseCase;
import com.fiap.gestaoUsuarios.infraestructure.adapters.SalvarPacienteAdapter;
import com.fiap.gestaoUsuarios.infraestructure.utils.mappers.PacienteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalvarUsuarioConfig {
    @Bean
    public SalvarPacienteUseCase salvarUsuarioUseCase(SalvarPacienteAdapter salvarUsuarioAdapter, PacienteMapper usuarioMapper)
    {
        return new SalvarPacienteUseCase(salvarUsuarioAdapter, usuarioMapper);
    }
}
