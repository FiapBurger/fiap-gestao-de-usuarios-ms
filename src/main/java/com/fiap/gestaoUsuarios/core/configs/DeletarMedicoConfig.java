package com.fiap.gestaoUsuarios.core.configs;

import com.fiap.gestaoUsuarios.core.usecase.DeletarMedicoUseCase;
import com.fiap.gestaoUsuarios.infraestructure.adapters.DeletarMedicoAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarMedicoConfig {

    @Bean
    public DeletarMedicoUseCase deletarMedicoUseCase(DeletarMedicoAdapter deletarMedicoAdapter){
        return new DeletarMedicoUseCase(deletarMedicoAdapter);
    }
}
