package uz.pdp.vehicle.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.pdp.vehicle.dto.CustomerCreateDTO;
import uz.pdp.vehicle.dto.ErrorDTO;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerValidation {
    public List<ErrorDTO> validate(CustomerCreateDTO customerCreateDTO) {
        List<ErrorDTO> errors = new ArrayList<>();
        if (customerCreateDTO.getPhoneNumber().length()!=13){
            errors.add(new ErrorDTO("phoneNumber", "phoneNumber invalid"));
        }
        return errors;
    }
}
