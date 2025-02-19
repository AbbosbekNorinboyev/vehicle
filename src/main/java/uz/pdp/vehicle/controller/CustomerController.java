package uz.pdp.vehicle.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.vehicle.dto.ApiResponse;
import uz.pdp.vehicle.dto.CustomerCreateDTO;
import uz.pdp.vehicle.entity.Customer;
import uz.pdp.vehicle.repository.CustomerRepository;
import uz.pdp.vehicle.service.impl.CustomerServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerServiceImpl customerService;
    private final CustomerRepository customerRepository;

    @PostMapping
    public ApiResponse<CustomerCreateDTO> createCustomer(@RequestBody @Valid CustomerCreateDTO customerCreateDTO) {
        return customerService.saveCustomer(customerCreateDTO);
    }

    @GetMapping("/{customerId}")
    public ApiResponse<CustomerCreateDTO> getCustomerById(@PathVariable Integer customerId) {
        return customerService.getCustomerById(customerId);
    }

    @GetMapping
    public ApiResponse<List<CustomerCreateDTO>> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @PutMapping
    public ApiResponse<Void> updateCustomer(@RequestBody @Valid Customer updateCustomer) {
        Customer customer = customerRepository.findById(updateCustomer.getId())
                .orElseThrow(() -> new RuntimeException("Customer not found: " + updateCustomer.getId()));
        if (updateCustomer.getAddress() != null) {
            customer.setAddress(updateCustomer.getAddress());
        }
        if (updateCustomer.getPhoneNumber() != null) {
            customer.setPhoneNumber(updateCustomer.getPhoneNumber());
        }
        if (updateCustomer.getUpdatedAt() != null) {
            customer.setUpdatedAt(updateCustomer.getUpdatedAt());
        }
        return customerService.updateCustomer(customer);
    }
}
