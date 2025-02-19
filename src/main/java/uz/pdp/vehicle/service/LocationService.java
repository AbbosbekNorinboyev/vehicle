package uz.pdp.vehicle.service;

import org.springframework.lang.NonNull;
import uz.pdp.vehicle.dto.ApiResponse;
import uz.pdp.vehicle.dto.LocationCreateDTO;
import uz.pdp.vehicle.entity.Location;

import java.util.List;

public interface LocationService {
    ApiResponse<LocationCreateDTO> saveLocation(@NonNull LocationCreateDTO locationCreateCTO);
    ApiResponse<LocationCreateDTO> getLocationById(@NonNull Integer locationId);
    ApiResponse<List<LocationCreateDTO>> getAllLocation();
    ApiResponse<Void> updateLocation(@NonNull Location location);
}
