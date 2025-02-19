package uz.pdp.vehicle.dto;

import lombok.*;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ErrorDTO {
    private String field;
    private String message;
}
