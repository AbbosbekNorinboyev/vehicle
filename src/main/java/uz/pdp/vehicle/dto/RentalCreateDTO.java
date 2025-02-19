package uz.pdp.vehicle.dto;

import lombok.*;
import uz.pdp.vehicle.entity.Customer;
import uz.pdp.vehicle.entity.Location;
import uz.pdp.vehicle.entity.Vehicle;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class RentalCreateDTO {
    private Customer customer;
    private Location location;
    private Vehicle vehicle;
}
