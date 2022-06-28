package com.example.Fistestfinal.dto;

import lombok.*;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CreateOrderDTO {
    private Long customerId;
    private ArrayList<ProductQuantityDTO> orderItemInfo;
}
