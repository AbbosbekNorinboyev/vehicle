package uz.pdp.vehicle.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationCreateDTO {
    private Integer id;
    @NotBlank(message = "address can not be null or empty")
    private String address;
    @NotBlank(message = "city can not be null or empty")
    private String city;
    @NotBlank(message = "state can not be null or empty")
    private String state;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}