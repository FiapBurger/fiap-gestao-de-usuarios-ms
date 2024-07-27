package com.fiap.gestaoUsuarios.core.configs;

import com.fiap.gestaoUsuarios.core.usecase.SalvarMedicoUseCase;
import com.fiap.gestaoUsuarios.infraestructure.adapters.SalvarMedicoAdapter;
import com.fiap.gestaoUsuarios.infraestructure.utils.mappers.MedicoMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalvarMedicoConfig {

    @Bean
    public SalvarMedicoUseCase salvarMedicoUseCase(SalvarMedicoAdapter salvarMedicoAdapter, MedicoMapper medicoMapper)
    {
        return new SalvarMedicoUseCase(salvarMedicoAdapter, medicoMapper);
    }
}
