package com.example.Fistestfinal.dto;

import com.example.Fistestfinal.model.Order;
import com.example.Fistestfinal.model.emum.OrderStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DetailOrderDTO {
    private Long id;

    private LocalDateTime orderDateTime;

    private CustomerDTO customerDTO;

    private Double totalAmount;

    private List<OrderItemDTO> orderItemDTOs;

    private OrderStatus status;

    public static class Mapper {
        public static DetailOrderDTO mapFromOrderEntity(Order order) {
            return DetailOrderDTO.builder()
                    .id(order.getId())
                    .orderDateTime(order.getOrderDateTime())
                    .customerDTO(CustomerDTO.Mapper.mapFromCustomerEntity(order.getCustomer()))
                    .totalAmount(order.getTotalAmount())
                    .orderItemDTOs(order.getOrderItems().stream()
                            .map(OrderItemDTO.Mapper::mapFromOrderItemEntity)
                            .collect(Collectors.toList()))
                    .status(order.getStatus())
                    .build();
        }
    }
}
