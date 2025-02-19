package uz.pdp.vehicle.service;

import org.springframework.lang.NonNull;
import uz.pdp.vehicle.dto.ApiResponse;
import uz.pdp.vehicle.dto.RentalCreateDTO;
import uz.pdp.vehicle.entity.Rental;

import java.util.List;

public interface RentalService {
    ApiResponse<RentalCreateDTO> saveRental(@NonNull RentalCreateDTO rentalCreateDTO);
    ApiResponse<RentalCreateDTO> getRental(@NonNull Integer rentalId);
    ApiResponse<List<RentalCreateDTO>> getAllRental();
}
