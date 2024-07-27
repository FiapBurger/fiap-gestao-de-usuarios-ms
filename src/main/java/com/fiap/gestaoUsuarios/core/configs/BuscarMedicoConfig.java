package com.fiap.gestaoUsuarios.core.configs;

import com.fiap.gestaoUsuarios.core.usecase.BuscarMedicoUseCase;
import com.fiap.gestaoUsuarios.infraestructure.adapters.BuscarMedicoAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarMedicoConfig {
    @Bean
    public BuscarMedicoUseCase buscarMedicoUseCase(BuscarMedicoAdapter buscarMedicoAdapter){
        return new BuscarMedicoUseCase(buscarMedicoAdapter);
    }
}
