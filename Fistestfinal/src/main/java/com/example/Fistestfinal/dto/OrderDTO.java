package com.example.Fistestfinal.dto;

import com.example.Fistestfinal.model.Order;
import com.example.Fistestfinal.model.emum.OrderStatus;
import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class OrderDTO {
    private Long id;

    private LocalDateTime orderDateTime;

    private Long customerId;

    private Double totalAmount;

    private OrderStatus status;

    public static class Mapper {
        public static OrderDTO mapFromOrderEntity(Order order) {
            return OrderDTO.builder()
                    .id(order.getId())
                    .customerId(order.getCustomer().getId())
                    .orderDateTime(order.getOrderDateTime())
                    .status(order.getStatus())
                    .totalAmount(order.getTotalAmount())
                    .build();
        }
    }
}
