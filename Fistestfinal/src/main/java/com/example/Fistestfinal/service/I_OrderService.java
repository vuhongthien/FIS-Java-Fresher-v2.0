package com.example.Fistestfinal.service;

import com.example.Fistestfinal.dto.AddOrderItemDTO;
import com.example.Fistestfinal.dto.CreateOrderDTO;
import com.example.Fistestfinal.dto.OrderDTO;
import com.example.Fistestfinal.dto.RemoveItemDTO;
import com.example.Fistestfinal.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface I_OrderService {
    Page<OrderDTO> findAll(Pageable pageable);
    Order findById(Long orderId);
    Order create(CreateOrderDTO createOrderDTO);
    void delete(Long orderId);
    Order addOrderItem(AddOrderItemDTO addOrderItemDTO);

    Order removeOrderItem(RemoveItemDTO removeItemDTO);
}
