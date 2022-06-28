package com.example.Fistestfinal.dto;

import com.example.Fistestfinal.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OrderItemDTO {
    private Long id;

    private ProductDTO productDTO;

    private Long quantity;

    private Double amount;

    public static class Mapper {
        public static OrderItemDTO mapFromOrderItemEntity(OrderItem orderItem) {
            return OrderItemDTO.builder()
                    .id(orderItem.getId())
                    .productDTO(ProductDTO.Mapper.mapFromProductEntity(orderItem.getProduct()))
                    .quantity(orderItem.getQuantity())
                    .amount(orderItem.getAmount())
                    .build();
        }
    }
}