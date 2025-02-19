package uz.pdp.vehicle.mapper;

import org.mapstruct.*;
import uz.pdp.vehicle.dto.VehicleCreateCTO;
import uz.pdp.vehicle.entity.Vehicle;

@Mapper(componentModel = "spring")
public interface VehicleMapper {
    Vehicle toEntity(VehicleCreateCTO vehicleCreateCTO);

    VehicleCreateCTO toDto(Vehicle vehicle);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Vehicle partialUpdate(VehicleCreateCTO vehicleCreateCTO, @MappingTarget Vehicle vehicle);
}