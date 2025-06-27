package co.edu.udistrital.taller2.repos;

import co.edu.udistrital.taller2.entitys.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
