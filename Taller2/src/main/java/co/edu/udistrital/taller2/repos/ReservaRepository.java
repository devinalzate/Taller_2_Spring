package co.edu.udistrital.taller2.repos;

import co.edu.udistrital.taller2.entitys.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//
@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {
}
