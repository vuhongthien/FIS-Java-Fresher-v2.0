package vn.fis.training.ordermanagement.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;


@SpringBootTest
@Slf4j
public class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    void loadAllOrder() {
        log.info("ORDER: {}",orderRepository.findById(1L).get());
    }

    @Test
    @Transactional
    void queryAllOrder_Using_CustomerOrderRepository() {
        orderRepository.findAllOrdersUsingCustomerRepository()
                .forEach(order -> log.info("Order: {}", order));
    }

    @Test
    void tesst() {
        log.info("ORDER: {}",orderRepository.findByIdUsingJoinFetch(1L).get());
    }
}
