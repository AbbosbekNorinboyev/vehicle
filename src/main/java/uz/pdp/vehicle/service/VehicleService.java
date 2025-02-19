package uz.pdp.vehicle.service;

import org.springframework.lang.NonNull;
import uz.pdp.vehicle.dto.ApiResponse;
import uz.pdp.vehicle.dto.VehicleCreateCTO;
import uz.pdp.vehicle.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    ApiResponse<VehicleCreateCTO> saveVehicle(@NonNull VehicleCreateCTO vehicleCreateCTO);
    ApiResponse<VehicleCreateCTO> getVehicle(@NonNull Integer vehicleId);
    ApiResponse<List<VehicleCreateCTO>> getAllVehicle();
    ApiResponse<Void> updateVehicle(@NonNull Vehicle vehicle);
}
