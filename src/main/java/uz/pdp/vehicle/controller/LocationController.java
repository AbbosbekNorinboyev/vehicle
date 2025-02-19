package uz.pdp.vehicle.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.vehicle.dto.ApiResponse;
import uz.pdp.vehicle.dto.LocationCreateDTO;
import uz.pdp.vehicle.entity.Location;
import uz.pdp.vehicle.repository.LocationRepository;
import uz.pdp.vehicle.service.LocationService;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;
    private final LocationRepository locationRepository;

    @PostMapping
    public ApiResponse<LocationCreateDTO> createLocation(@RequestBody @Valid LocationCreateDTO locationCreateDTO) {
        return locationService.saveLocation(locationCreateDTO);
    }

    @GetMapping("/{locationId}")
    public ApiResponse<LocationCreateDTO> getLocationById(@PathVariable Integer locationId) {
        return locationService.getLocationById(locationId);
    }

    @GetMapping
    public ApiResponse<List<LocationCreateDTO>> getAllLocation() {
        return locationService.getAllLocation();
    }

    @PutMapping
    public ApiResponse<Void> updateLocation(@RequestBody Location updateLocation) {
        Location location = locationRepository.findById(updateLocation.getId())
                .orElseThrow(() -> new RuntimeException("Location not found: " + updateLocation.getId()));
        if (updateLocation.getAddress() != null) {
            location.setAddress(location.getAddress());
        }
        if (updateLocation.getCity() != null) {
            location.setCity(location.getCity());
        }
        if (updateLocation.getState() != null) {
            location.setState(updateLocation.getState());
        }
        if (updateLocation.getUpdatedAt() != null) {
            location.setUpdatedAt(updateLocation.getUpdatedAt());
        }
        return locationService.updateLocation(location);
    }
}
