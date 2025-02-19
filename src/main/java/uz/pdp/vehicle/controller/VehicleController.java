package uz.pdp.vehicle.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.vehicle.dto.ApiResponse;
import uz.pdp.vehicle.dto.VehicleCreateCTO;
import uz.pdp.vehicle.entity.Vehicle;
import uz.pdp.vehicle.repository.VehicleRepository;
import uz.pdp.vehicle.service.VehicleService;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;
    private final VehicleRepository vehicleRepository;

    @PostMapping
    public ApiResponse<VehicleCreateCTO> createVehicle(@RequestBody @Valid VehicleCreateCTO vehicleCreateCTO) {
        return vehicleService.saveVehicle(vehicleCreateCTO);
    }

    @GetMapping("/{vehicleId}")
    public ApiResponse<VehicleCreateCTO> getVehicle(@PathVariable Integer vehicleId) {
        return vehicleService.getVehicle(vehicleId);
    }

    @GetMapping
    public ApiResponse<List<VehicleCreateCTO>> getAllVehicle() {
        return vehicleService.getAllVehicle();
    }

    @PutMapping
    public ApiResponse<Void> updateVehicle(@RequestBody Vehicle updateVehicle) {
        Vehicle vehicle = vehicleRepository.findById(updateVehicle.getId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found: " + updateVehicle.getId()));
        if (updateVehicle.getType() != null) {
            vehicle.setType(updateVehicle.getType());
        }
        if (updateVehicle.getModelNumber() != null) {
            vehicle.setModelNumber(updateVehicle.getModelNumber());
        }
        if (updateVehicle.getUpdatedAt() != null) {
            vehicle.setUpdatedAt(updateVehicle.getUpdatedAt());
        }
        return vehicleService.updateVehicle(vehicle);
    }
}
