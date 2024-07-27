package com.fiap.gestaoUsuarios.core.configs;

import com.fiap.gestaoUsuarios.core.usecase.EditarMedicoUseCase;
import com.fiap.gestaoUsuarios.infraestructure.adapters.EditarMedicoAdapter;
import com.fiap.gestaoUsuarios.infraestructure.utils.mappers.MedicoMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EditarMedicoConfig {
    @Bean
    public EditarMedicoUseCase editarMedicoUseCase(EditarMedicoAdapter editarMedicoAdapter, MedicoMapper medicoMapper){
        return new EditarMedicoUseCase(editarMedicoAdapter, medicoMapper);
    }
}
