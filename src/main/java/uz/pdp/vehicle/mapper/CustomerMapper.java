package uz.pdp.vehicle.mapper;

import org.mapstruct.*;
import uz.pdp.vehicle.dto.CustomerCreateDTO;
import uz.pdp.vehicle.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toEntity(CustomerCreateDTO customerCreateDTO);

    CustomerCreateDTO toDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer partialUpdate(CustomerCreateDTO customerCreateDTO, @MappingTarget Customer customer);
}