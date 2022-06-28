package com.example.Fistestfinal.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AddOrderItemDTO {
    private Long orderId;
    private Long productId;
    private Long quantity;
}
