package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Customer;
import model.OrderCart;
import model.OrderItem;
import model.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderCartDTO {
    private Long id;
    private LocalDateTime orderDateTime;
    private Long customerId;
    private List<OrderItem> orderItems ;
    private Double totalAmount;
    private OrderStatus status;

    public static class Mapper{
        public static OrderCartDTO fromEmtity(OrderCart orderCart){
            return OrderCartDTO.builder().id(orderCart.getId())
                    .orderDateTime(orderCart.getOrderDateTime())
                    .customerId(orderCart.getCustomer().getId())
                    .totalAmount(orderCart.getTotalAmount())
                    .status(orderCart.getStatus()).build();
        }
    }


}
