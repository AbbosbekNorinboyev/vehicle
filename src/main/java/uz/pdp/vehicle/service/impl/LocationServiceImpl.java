package uz.pdp.vehicle.service.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import uz.pdp.vehicle.dto.ApiResponse;
import uz.pdp.vehicle.dto.LocationCreateDTO;
import uz.pdp.vehicle.entity.Location;
import uz.pdp.vehicle.exception.ResourceNotFoundException;
import uz.pdp.vehicle.mapper.LocationMapper;
import uz.pdp.vehicle.repository.LocationRepository;
import uz.pdp.vehicle.service.LocationService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationMapper locationMapper;
    private final LocationRepository locationRepository;
    private final Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);


    @Override
    public ApiResponse<LocationCreateDTO> saveLocation(@NonNull LocationCreateDTO locationCreateCTO) {
        Location location = locationMapper.toEntity(locationCreateCTO);
        locationRepository.save(location);
        return ApiResponse.<LocationCreateDTO>builder()
                .code(200)
                .message("Location successfully saved")
                .success(true)
                .data(locationMapper.toDto(location))
                .build();
    }

    @Override
    public ApiResponse<LocationCreateDTO> getLocationById(@NonNull Integer locationId) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new ResourceNotFoundException("Location not found: " + locationId));
        return ApiResponse.<LocationCreateDTO>builder()
                .code(200)
                .message("Location successfully found")
                .success(true)
                .data(locationMapper.toDto(location))
                .build();
    }

    @Override
    public ApiResponse<List<LocationCreateDTO>> getAllLocation() {
        List<Location> locations = locationRepository.findAll();
        logger.info("Location list successfully found");
        return ApiResponse.<List<LocationCreateDTO>>builder()
                .code(200)
                .message("Location list successfully found")
                .success(true)
                .data(locations.stream().map(locationMapper::toDto).toList())
                .build();
    }

    @Override
    public ApiResponse<Void> updateLocation(@NonNull Location location) {
        locationRepository.save(location);
        return ApiResponse.<Void>builder()
                .code(200)
                .message("Location successfully updated")
                .success(true)
                .build();
    }
}
