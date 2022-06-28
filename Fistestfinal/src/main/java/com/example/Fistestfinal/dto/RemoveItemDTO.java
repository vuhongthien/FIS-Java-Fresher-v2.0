package com.example.Fistestfinal.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RemoveItemDTO {
    private Long orderId;
    private Long orderItemId;
}
