package com.example.Fistestfinal.dto;

import com.example.Fistestfinal.model.Product;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductDTO {
    private Long id;

    private String name;

    private Double price;

    private Double avaiable;

    public static class Mapper {
        public static ProductDTO mapFromProductEntity(Product product) {
            return ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .avaiable(product.getAvaiable())
                    .build();
        }
    }
}
