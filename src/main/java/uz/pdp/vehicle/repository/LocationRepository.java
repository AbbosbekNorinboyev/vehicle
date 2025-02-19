package uz.pdp.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.vehicle.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Transactional
    @Modifying
    @Query(value = "delete from location l where l.id = ?1", nativeQuery = true)
    void deleteLocationById(Integer locationId);
}