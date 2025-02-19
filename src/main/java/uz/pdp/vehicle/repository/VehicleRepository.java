package uz.pdp.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.vehicle.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    @Transactional
    @Modifying
    @Query(value = "delete from vehicle v where v.id = ?1", nativeQuery = true)
    void deleteVehicleById(Integer vehicleId);
}