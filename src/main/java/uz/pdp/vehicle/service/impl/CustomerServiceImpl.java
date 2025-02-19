package uz.pdp.vehicle.service.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import uz.pdp.vehicle.dto.ApiResponse;
import uz.pdp.vehicle.dto.CustomerCreateDTO;
import uz.pdp.vehicle.entity.Customer;
import uz.pdp.vehicle.exception.ResourceNotFoundException;
import uz.pdp.vehicle.mapper.CustomerMapper;
import uz.pdp.vehicle.repository.CustomerRepository;
import uz.pdp.vehicle.service.CustomerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Override
    public ApiResponse<CustomerCreateDTO> saveCustomer(@NonNull CustomerCreateDTO customerCreateDTO) {
        Customer customer = customerMapper.toEntity(customerCreateDTO);
        customerRepository.save(customer);
        return ApiResponse.<CustomerCreateDTO>builder()
                .code(200)
                .message("Customer successfully saved")
                .success(true)
                .data(customerMapper.toDto(customer))
                .build();
    }

    @Override
    public ApiResponse<CustomerCreateDTO> getCustomerById(@NonNull Integer customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found: " + customerId));
        return ApiResponse.<CustomerCreateDTO>builder()
                .code(200)
                .message("Customer successfully found")
                .success(true)
                .data(customerMapper.toDto(customer))
                .build();
    }

    @Override
    public ApiResponse<List<CustomerCreateDTO>> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        logger.info("Customer list successfully found");
        return ApiResponse.<List<CustomerCreateDTO>>builder()
                .code(200)
                .message("Customer list successfully found")
                .success(true)
                .data(customers.stream().map(customerMapper::toDto).toList())
                .build();
    }

    @Override
    public ApiResponse<Void> updateCustomer(@NonNull Customer customer) {
        customerRepository.save(customer);
        return ApiResponse.<Void>builder()
                .code(200)
                .message("Customer successfully updated")
                .success(true)
                .build();
    }
}
