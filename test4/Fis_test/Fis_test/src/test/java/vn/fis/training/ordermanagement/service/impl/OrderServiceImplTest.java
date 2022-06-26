package vn.fis.training.ordermanagement.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import vn.fis.training.ordermanagement.dto.CreateOrderItemDTO;
import vn.fis.training.ordermanagement.model.Order;
import vn.fis.training.ordermanagement.service.OrderService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class OrderServiceImplTest {

    @Autowired
    OrderService orderService;

    @Test
    void addOrderItem() {
        CreateOrderItemDTO  createOrderItemDTO = CreateOrderItemDTO.builder()
                .orderId(1L).productId(2L).quantity(2).build();
        Order order = orderService.addOrderItem(createOrderItemDTO);

        log.info("Order: {}",order);
    }
}