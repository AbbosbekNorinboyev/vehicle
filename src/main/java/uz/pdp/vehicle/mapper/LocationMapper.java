package uz.pdp.vehicle.mapper;

import org.mapstruct.*;
import uz.pdp.vehicle.dto.LocationCreateDTO;
import uz.pdp.vehicle.entity.Location;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    Location toEntity(LocationCreateDTO locationCreateDTO);

    LocationCreateDTO toDto(Location location);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Location partialUpdate(LocationCreateDTO locationCreateDTO, @MappingTarget Location location);
}