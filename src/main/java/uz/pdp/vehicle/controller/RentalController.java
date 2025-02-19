package uz.pdp.vehicle.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.vehicle.dto.ApiResponse;
import uz.pdp.vehicle.dto.RentalCreateDTO;
import uz.pdp.vehicle.entity.Rental;
import uz.pdp.vehicle.service.impl.RentalServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@RequiredArgsConstructor
public class RentalController {
    private final RentalServiceImpl rentalService;

    @PostMapping
    public ApiResponse<RentalCreateDTO> saveRental(@RequestBody @Valid RentalCreateDTO rentalCreateDTO) {
        return rentalService.saveRental(rentalCreateDTO);
    }

    @GetMapping("/{rentalId}")
    public ApiResponse<RentalCreateDTO> getRental(@PathVariable Integer rentalId) {
        return rentalService.getRental(rentalId);
    }

    @GetMapping
    public ApiResponse<List<RentalCreateDTO>> getAllRental() {
        return rentalService.getAllRental();
    }
}
