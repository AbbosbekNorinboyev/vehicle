package uz.pdp.vehicle.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleCreateCTO {
    private Integer id;
    @NotBlank(message = "modelNumber can not be null or empty")
    private String modelNumber;
    @NotBlank(message = "type can not be null or empty")
    private String type;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}