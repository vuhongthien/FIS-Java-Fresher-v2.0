package com.example.Fistestfinal.service.impl;

import com.example.Fistestfinal.dto.CustomerDTO;
import com.example.Fistestfinal.model.Customer;
import com.example.Fistestfinal.repo.ICustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;
@Slf4j
class ImpCustomerServiceTest {
    private ImpCustomerService impCustomerService;

    private ICustomerRepo iCustomerRepo;
    private Customer customer;
    private Pageable pageable;

    @Test
    void findAll() {
        List<Customer> c = new ArrayList<>();
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();
        c.add(customer1);
        c.add(customer2);
        c.add(customer3);
        Page<Customer> customers = new PageImpl<>(c);

        when(iCustomerRepo.findAll(pageable)).thenReturn(customers);
        log.info("Customer: {}", c.size());
        Page<CustomerDTO> customerDTOPage = impCustomerService.findAll(pageable);

        assertEquals(customerDTOPage.getTotalElements(), customers.getTotalElements());
        verify(iCustomerRepo, times(1)).findAll(pageable);
    }

    @Test
    void findById() {
        when(iCustomerRepo.findById(1L)).thenReturn(Optional.ofNullable(customer));
        Customer c1 = impCustomerService.findById(1L);
        log.info("id = 1L: {}", customer);
        assertThat(c1).isNotNull();
        assertThat(c1.getName()).isEqualTo("ABC");
        assertThat(c1.getAddress()).isEqualTo("ABC");
        assertThat(c1.getMobile()).isEqualTo("1234567899");
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
        Long id = 1L;
        willDoNothing().given(iCustomerRepo).deleteById(id);
        impCustomerService.delete(id);
        verify(iCustomerRepo, times(1)).deleteById(id);
    }
}