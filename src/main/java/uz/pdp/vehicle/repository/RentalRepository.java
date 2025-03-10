package uz.pdp.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.vehicle.entity.Rental;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

}