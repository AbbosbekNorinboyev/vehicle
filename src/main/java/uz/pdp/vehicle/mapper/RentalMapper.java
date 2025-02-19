package uz.pdp.vehicle.mapper;

import org.mapstruct.*;
import uz.pdp.vehicle.dto.RentalCreateDTO;
import uz.pdp.vehicle.entity.Rental;

@Mapper(componentModel = "spring")
public interface RentalMapper {
    Rental toEntity(RentalCreateDTO rentalCreateDTO);

    RentalCreateDTO toDto(Rental rental);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Rental partialUpdate(RentalCreateDTO rentalCreateDTO, @MappingTarget Rental rental);
}