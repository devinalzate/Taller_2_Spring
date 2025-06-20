package co.edu.udistrital.taller2.repos;

import co.edu.udistrital.taller2.entitys.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
}
