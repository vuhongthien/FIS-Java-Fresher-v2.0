package com.example.Fistestfinal.controllers;

import com.example.Fistestfinal.dto.CreateCustomerDTO;
import com.example.Fistestfinal.dto.CustomerDTO;
import com.example.Fistestfinal.model.Customer;
import com.example.Fistestfinal.service.impl.ImpCustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.BadRequestException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/api/customer")
public class CustomerController {
    @Autowired
    private ImpCustomerService impCustomerService;
    /** Find All **/
    // http://localhost:8080/api/customer/{pageNumber}/{pageSize}
    @GetMapping("/{pageNumber}/{pageSize}")
    public Page<CustomerDTO> findAll(@PathVariable(name = "pageNumber") Integer pageNumber
            , @PathVariable(name = "pageSize") Integer pageSize) {
        log.info("Tất cã Customers. PageNumber: {}, PageSize: {}", pageNumber, pageSize);
        return impCustomerService.findAll(PageRequest.of(pageNumber, pageSize));
    }
    /** Find By Id **/
    // http://localhost:8080/api/customer/{customerId}
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> findById(@PathVariable(name = "customerId") Long customerId) {
        return new ResponseEntity<>(impCustomerService.findById(customerId),HttpStatus.OK);
    }
    /** Create **/
    // http://localhost:8080/api/customer/{pageNumber}/{pageSize}
    @PostMapping("/{pageNumber}/{pageSize}")
    public Page<CustomerDTO> create(@RequestBody CreateCustomerDTO createCustomerDTO,
                                    @PathVariable(name = "pageNumber") Integer pageNumber,
                                    @PathVariable(name = "pageSize") Integer pageSize)
                                    throws BadRequestException {
        Page<CustomerDTO> customerDTOPage = impCustomerService.create
                (createCustomerDTO, PageRequest.of(pageNumber, pageSize));
        return customerDTOPage;
    }
    /** Update **/
    // http://localhost:8080/api/customer/{customerId}
    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> update(@PathVariable("customerId") Long customerId,
                                              @RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<>(
                impCustomerService.update(customerId, customerDTO),HttpStatus.OK);
    }
    /** Delete **/
    // http://localhost:8080/api/customer/{customerId}
    @DeleteMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> delete(@PathVariable(value = "customerId") Long customerId){
        impCustomerService.delete(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
