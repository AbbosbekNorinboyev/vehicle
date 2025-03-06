package uz.pdp.vehicle.service.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import uz.pdp.vehicle.dto.ApiResponse;
import uz.pdp.vehicle.dto.RentalCreateDTO;
import uz.pdp.vehicle.entity.Customer;
import uz.pdp.vehicle.entity.Location;
import uz.pdp.vehicle.entity.Rental;
import uz.pdp.vehicle.entity.Vehicle;
import uz.pdp.vehicle.exception.ResourceNotFoundException;
import uz.pdp.vehicle.mapper.RentalMapper;
import uz.pdp.vehicle.repository.CustomerRepository;
import uz.pdp.vehicle.repository.LocationRepository;
import uz.pdp.vehicle.repository.RentalRepository;
import uz.pdp.vehicle.repository.VehicleRepository;
import uz.pdp.vehicle.service.RentalService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;
    private final RentalMapper rentalMapper;
    private final Logger logger = LoggerFactory.getLogger(RentalServiceImpl.class);
    private final CustomerRepository customerRepository;
    private final LocationRepository locationRepository;
    private final VehicleRepository vehicleRepository;

    @Override
    public ApiResponse<RentalCreateDTO> saveRental(@NonNull RentalCreateDTO rentalCreateDTO) {
        Rental rental = rentalMapper.toEntity(rentalCreateDTO);
        rentalRepository.save(rental);
        return ApiResponse.<RentalCreateDTO>builder()
                .code(HttpStatus.OK.value())
                .message("Rental successfully found")
                .success(true)
                .data(rentalMapper.toDto(rental))
                .build();
    }

    @Override
    public ApiResponse<RentalCreateDTO> getRental(@NonNull Integer rentalId) {
        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new ResourceNotFoundException("Rental not found: " + rentalId));
        return ApiResponse.<RentalCreateDTO>builder()
                .code(HttpStatus.OK.value())
                .message("Rental successfully found")
                .success(true)
                .data(rentalMapper.toDto(rental))
                .build();
    }

    @Override
    public ApiResponse<List<RentalCreateDTO>> getAllRental() {
        List<Rental> rentals = rentalRepository.findAll();
        logger.info("Rental list successfully found");
        return ApiResponse.<List<RentalCreateDTO>>builder()
                .code(HttpStatus.OK.value())
                .message("Rental list successfully found")
                .success(true)
                .data(rentals.stream().map(rentalMapper::toDto).toList())
                .build();
    }
}
