package com.fiap.gestaoUsuarios.infraestructure.persistence.repositorys;

import com.fiap.gestaoUsuarios.infraestructure.persistence.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity, String>{
}
