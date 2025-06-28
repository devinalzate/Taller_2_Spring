package co.edu.udistrital.taller2.repos;

import co.edu.udistrital.taller2.entitys.FacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<FacturaEntity, Long> {
}
