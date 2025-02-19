package uz.pdp.vehicle.service;

import org.springframework.lang.NonNull;
import uz.pdp.vehicle.dto.ApiResponse;
import uz.pdp.vehicle.dto.CustomerCreateDTO;
import uz.pdp.vehicle.entity.Customer;

import java.util.List;

public interface CustomerService {
    ApiResponse<CustomerCreateDTO> saveCustomer(@NonNull CustomerCreateDTO customerCreateDTO);
    ApiResponse<CustomerCreateDTO> getCustomerById(@NonNull Integer customerId);
    ApiResponse<List<CustomerCreateDTO>> getAllCustomer();
    ApiResponse<Void> updateCustomer(@NonNull Customer customer);

}
