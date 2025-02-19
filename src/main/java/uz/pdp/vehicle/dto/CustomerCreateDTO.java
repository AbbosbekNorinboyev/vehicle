package uz.pdp.vehicle.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCreateDTO {
    private Integer id;
    @NotBlank(message = "name can not be null or empty")
    private String name;
    @NotBlank(message = "address can not be null or empty")
    private String address;
    @NotBlank(message = "phoneNumber can nto be null or empty")
    private String phoneNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}