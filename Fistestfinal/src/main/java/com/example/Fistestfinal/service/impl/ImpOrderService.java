package com.example.Fistestfinal.service.impl;

import com.example.Fistestfinal.dto.AddOrderItemDTO;
import com.example.Fistestfinal.dto.CreateOrderDTO;
import com.example.Fistestfinal.dto.OrderDTO;
import com.example.Fistestfinal.dto.RemoveItemDTO;
import com.example.Fistestfinal.exception.*;
import com.example.Fistestfinal.model.Customer;
import com.example.Fistestfinal.model.Order;
import com.example.Fistestfinal.model.OrderItem;
import com.example.Fistestfinal.model.Product;
import com.example.Fistestfinal.model.emum.OrderStatus;
import com.example.Fistestfinal.service.I_CustomerService;
import com.example.Fistestfinal.service.I_OrderService;
import com.example.Fistestfinal.service.I_ProductService;
import com.example.Fistestfinal.status.StatusError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.Fistestfinal.repo.IOrderRepo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ImpOrderService implements I_OrderService {
    @Autowired
    private IOrderRepo orderRepo;
    @Autowired
    private I_CustomerService i_customerService;
    @Autowired
    private I_ProductService i_productService;
    public ImpOrderService(IOrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public Page<OrderDTO> findAll(Pageable pageable) {
        log.info("Tất cả order: PageNumber: {}, PageSize: {}", pageable.getPageNumber(), pageable.getPageSize());
        return orderRepo.findAll(pageable).map(OrderDTO.Mapper::mapFromOrderEntity);
    }

    @Override
    public Order findById(Long orderId) {
        Order order = orderRepo.findById(orderId).orElseThrow(() -> {
            try {
                throw new OrderNotFoundException(
                        String.format(StatusError.ERROR_ORDER_NOT_FOUND + orderId));
            } catch (OrderNotFoundException exception) {
                throw new RuntimeException(exception);
            }
        });
        log.info("Order: {}", order);
        return order;
    }

    @Override
    public Order create(CreateOrderDTO createOrderDTO) {
        Customer customer = i_customerService.findById(createOrderDTO.getCustomerId());
        List<OrderItem> orderItemList = new ArrayList<>();
        createOrderDTO.getOrderItemInfo().forEach(productQuantityDTO -> {
            Product product = i_productService.findById(productQuantityDTO.getProductId());
            if (product.getAvaiable() < productQuantityDTO.getQuantity()) {
                try {
                    throw new ProductNotFoundException(
                            String.format(StatusError.ERROR_PRODUCT_NOT_FOUND + product.getName()));
                } catch (ProductNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            OrderItem orderItem = OrderItem.builder()
                    .product(product)
                    .quantity(productQuantityDTO.getQuantity())
                    .amount(product.getPrice() * productQuantityDTO.getQuantity())
                    .build();
            orderItemList.add(orderItem);
        });
        Order order = Order.builder()
                .orderDateTime(LocalDateTime.now())
                .status(OrderStatus.CREATED)
                .customer(customer)
                .orderItems(orderItemList)
                .totalAmount(orderItemList.stream().mapToDouble(OrderItem::getAmount).sum())
                .build();
        orderRepo.save(order);
        return order;
    }

    @Override
    public void delete(Long orderId) {
        Order order = findById(orderId);
        if (OrderStatus.PAID.equals(order.getStatus())) {
            try {
                throw new CanNotDeletePaidStatusOrderException(
                        StatusError.ERROR_ORDER_NOT_DELETE);
            } catch (CanNotDeletePaidStatusOrderException e) {
                throw new RuntimeException(e);
            }
        }
        orderRepo.deleteById(orderId);
    }

    @Override
    public Order addOrderItem(AddOrderItemDTO addOrderItemDTO) {
        Order order = findById(addOrderItemDTO.getOrderId());
        if (!OrderStatus.CREATED.equals(order.getStatus())) {
            try {
                throw new OrderItemToCreatedOrderException(StatusError.ERROR_ORDER_NOT_ADD_ORDER_ITEM);
            } catch (OrderItemToCreatedOrderException e) {
                throw new RuntimeException(e);
            }
        }
        Product product = i_productService.findById(addOrderItemDTO.getProductId());
        if (product.getAvaiable() < addOrderItemDTO.getQuantity()) {
            try {
                throw new ProductNotFoundException(String.format(
                        StatusError.ERROR_PRODUCT_NOT_FOUND + product.getName()));
            } catch (ProductNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        OrderItem newOrderItem = OrderItem.builder()
                .amount(product.getPrice() * addOrderItemDTO.getQuantity())
                .quantity(addOrderItemDTO.getQuantity())
                .order(order)
                .product(product)
                .build();
        order.setTotalAmount(order.getTotalAmount() + newOrderItem.getAmount());
        order.getOrderItems().add(newOrderItem);
        orderRepo.save(order);
        product.setAvaiable(product.getAvaiable() - addOrderItemDTO.getQuantity());
        i_productService.update(product);
        return order;
    }

    @Override
    public Order removeOrderItem(RemoveItemDTO removeItemDTO) {
        return null;
    }
}
