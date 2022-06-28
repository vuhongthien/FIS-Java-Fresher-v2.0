package com.example.Fistestfinal.service.impl;

import com.example.Fistestfinal.dto.CreateCustomerDTO;
import com.example.Fistestfinal.dto.CustomerDTO;
import com.example.Fistestfinal.exception.CustomerNotFoundException;
import com.example.Fistestfinal.model.Customer;
import com.example.Fistestfinal.status.StatusError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.Fistestfinal.repo.ICustomerRepo;
import com.example.Fistestfinal.service.I_CustomerService;


import javax.ws.rs.NotFoundException;
import java.util.Optional;

@Service
@Slf4j
public class ImpCustomerService implements I_CustomerService {
    @Autowired
    private ICustomerRepo cusRepo;
    public ImpCustomerService(ICustomerRepo cusRepo) {
        this.cusRepo = cusRepo;
    }

    @Override
    public Page<CustomerDTO> findAll(Pageable pageable) {
        return cusRepo.findAll(pageable)
                .map(CustomerDTO.Mapper::mapFromCustomerEntity);
    }

    @Override
    public Customer findById(Long customerId) {
        Customer customer = cusRepo.findById(customerId).orElseThrow(() -> {
            try {
                throw new CustomerNotFoundException(
                        String.format(StatusError.ERROR_CUSTOMER_NOT_FOUND + customerId));
            } catch (CustomerNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        log.info("Service: Customer: {}", customer);
        return customer;
    }

    @Override
    public Page<CustomerDTO> create(CreateCustomerDTO createCustomerDTO, Pageable pageable) {
        Customer customer = Customer.builder()
                .name(createCustomerDTO.getName())
                .mobile(createCustomerDTO.getMobile())
                .address(createCustomerDTO.getAddress()).build();
        cusRepo.save(customer);
        log.info("Đã tạo Customer: {}", customer);
        return findAll(pageable);
    }

    @Override
    public CustomerDTO update(Long customerId, CustomerDTO customerDTO) {
        Optional<Customer> customer = cusRepo.findById(customerDTO.getId());
        Customer c = cusRepo.findById(customerId).get();
        c.setAddress(customerDTO.getAddress());
        c.setMobile(customerDTO.getMobile());
        Customer updatedCustomer = cusRepo.save(c);
        log.info("Customer: {}", updatedCustomer);
        return CustomerDTO.Mapper.mapFromCustomerEntity(updatedCustomer);
    }

    @Override
    public void delete(Long customerId) {
        cusRepo.findById(customerId).orElseThrow(() ->
                new NotFoundException(StatusError.ERROR_CUSTOMER_NOT_FOUND + customerId));
        cusRepo.deleteById(customerId);
    }
}
