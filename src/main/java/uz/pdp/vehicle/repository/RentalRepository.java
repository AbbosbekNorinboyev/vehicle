package uz.pdp.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.vehicle.entity.Rental;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

}