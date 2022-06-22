package service;

import dto.OrderCartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface InterfaceOrderCart {
    Page<OrderCartDTO> findOrderCart(Pageable pageable);
}
