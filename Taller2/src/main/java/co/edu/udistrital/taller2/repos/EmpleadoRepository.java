package co.edu.udistrital.taller2.repos;

import co.edu.udistrital.taller2.entitys.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long> {
}
