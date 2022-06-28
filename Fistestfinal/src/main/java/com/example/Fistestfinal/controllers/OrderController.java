package com.example.Fistestfinal.controllers;

import com.example.Fistestfinal.dto.AddOrderItemDTO;
import com.example.Fistestfinal.dto.CreateOrderDTO;
import com.example.Fistestfinal.dto.DetailOrderDTO;
import com.example.Fistestfinal.dto.OrderDTO;
import com.example.Fistestfinal.model.Order;
import com.example.Fistestfinal.service.impl.ImpOrderService;
import com.example.Fistestfinal.status.StatusError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@Slf4j
public class OrderController {
    @Autowired
    private ImpOrderService impOrderService;
    @Autowired
    public OrderController(ImpOrderService impOrderService) {
        this.impOrderService = impOrderService;
    }
    /** Find All **/
    // http://localhost:8080/api/customer/{pageNumber}/{pageSize}
    @GetMapping("/{pageNumber}/{pageSize}")
    public Page<OrderDTO> findAll(@PathVariable("pageNumber") Integer pageNumber,
                                  @PathVariable("pageSize") Integer pageSize) {
        log.info("Response All Order. PageNumber: {}, PageSize: {}", pageNumber, pageSize);
        return impOrderService.findAll(PageRequest.of(pageNumber, pageSize));
    }

    /** Find By Id **/
    // http://localhost:8080/api/customer/{orderId}
    @GetMapping("/{orderId}")
    public ResponseEntity<DetailOrderDTO> findById(@PathVariable("orderId") Long orderId) {
        Order order = impOrderService.findById(orderId);
        DetailOrderDTO detailOrderDTO = DetailOrderDTO.Mapper.mapFromOrderEntity(order);
        log.info("DetailOrder with id {}: {}", orderId,detailOrderDTO);
        return new ResponseEntity<>(detailOrderDTO, HttpStatus.OK);
    }

    /** Create **/
    // http://localhost:8080/api/customer/
    @PutMapping("/")
    public ResponseEntity<DetailOrderDTO> create(
                                                 @RequestBody CreateOrderDTO createOrderDTO) {
        log.info("CreateOrderDTO: {} and id {}", createOrderDTO);
        Order savedOrder = impOrderService.create(createOrderDTO);
        DetailOrderDTO detailOrderDTO = DetailOrderDTO.Mapper.mapFromOrderEntity(savedOrder);
        log.info("Saved Detail Order: {}", detailOrderDTO);
        return new ResponseEntity<>(detailOrderDTO, HttpStatus.OK);
    }

    /** Delete **/
    // http://localhost:8080/api/{orderId}
    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> delete(@PathVariable("orderId") Long orderId) {
        impOrderService.delete(orderId);
        return new ResponseEntity<>(StatusError.DELETE_SUCCESS, HttpStatus.OK);
    }

    /** Add Order Item **/
    // http://localhost:8080/api/addOrderItem
    @PostMapping("/addOrderItem")
    public ResponseEntity<DetailOrderDTO> addOrderItem(@RequestBody AddOrderItemDTO addOrderItemDTO) {
        log.info("Order Item: {}", addOrderItemDTO);
        Order order = impOrderService.addOrderItem(addOrderItemDTO);
        DetailOrderDTO detailOrderDTO = DetailOrderDTO.Mapper.mapFromOrderEntity(order);
        log.info(" new OrderItem: {}", detailOrderDTO);
        return new ResponseEntity<>(detailOrderDTO, HttpStatus.OK);
    }
}
