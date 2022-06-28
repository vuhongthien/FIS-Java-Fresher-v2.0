package com.example.Fistestfinal.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductQuantityDTO {
    private Long productId;
    private Long quantity;
}
