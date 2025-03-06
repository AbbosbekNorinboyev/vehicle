package uz.pdp.vehicle.service.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import uz.pdp.vehicle.dto.ApiResponse;
import uz.pdp.vehicle.dto.VehicleCreateCTO;
import uz.pdp.vehicle.entity.Vehicle;
import uz.pdp.vehicle.exception.ResourceNotFoundException;
import uz.pdp.vehicle.mapper.VehicleMapper;
import uz.pdp.vehicle.repository.VehicleRepository;
import uz.pdp.vehicle.service.VehicleService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleMapper vehicleMapper;
    private final VehicleRepository vehicleRepository;
    private final Logger logger = LoggerFactory.getLogger(VehicleServiceImpl.class);


    @Override
    public ApiResponse<VehicleCreateCTO> saveVehicle(@NonNull VehicleCreateCTO vehicleCreateCTO) {
        Vehicle vehicle = vehicleMapper.toEntity(vehicleCreateCTO);
        vehicleRepository.save(vehicle);
        return ApiResponse.<VehicleCreateCTO>builder()
                .code(HttpStatus.OK.value())
                .message("Vehicle successfully saved")
                .success(true)
                .data(vehicleMapper.toDto(vehicle))
                .build();
    }

    @Override
    public ApiResponse<VehicleCreateCTO> getVehicle(@NonNull Integer vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found: " + vehicleId));
        return ApiResponse.<VehicleCreateCTO>builder()
                .code(HttpStatus.OK.value())
                .message("Vehicle successfully found")
                .success(true)
                .data(vehicleMapper.toDto(vehicle))
                .build();
    }

    @Override
    public ApiResponse<List<VehicleCreateCTO>> getAllVehicle() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        logger.info("Vehicle list successfullyt found");
        return ApiResponse.<List<VehicleCreateCTO>>builder()
                .code(HttpStatus.OK.value())
                .message("Vehicle list successfully found")
                .success(true)
                .data(vehicles.stream().map(vehicleMapper::toDto).toList())
                .build();
    }

    @Override
    public ApiResponse<Void> updateVehicle(@NonNull Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return ApiResponse.<Void>builder()
                .code(HttpStatus.OK.value())
                .message("Vehicle successfully updated")
                .success(true)
                .build();
    }
}
