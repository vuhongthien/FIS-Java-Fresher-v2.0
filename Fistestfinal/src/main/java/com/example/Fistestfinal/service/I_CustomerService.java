package com.example.Fistestfinal.service;

import com.example.Fistestfinal.dto.CreateCustomerDTO;
import com.example.Fistestfinal.dto.CustomerDTO;
import com.example.Fistestfinal.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface I_CustomerService {
    Page<CustomerDTO> findAll(Pageable pageable);

    Customer findById(Long customerId);

    Page<CustomerDTO> create(CreateCustomerDTO createCustomerDTO, Pageable pageable);

    CustomerDTO update(Long customerId, CustomerDTO customerDTO);

    void delete(Long customerId);
}
