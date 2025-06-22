package co.edu.udistrital.taller2.repos;

import co.edu.udistrital.taller2.entitys.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<HotelEntity, String> {
}
