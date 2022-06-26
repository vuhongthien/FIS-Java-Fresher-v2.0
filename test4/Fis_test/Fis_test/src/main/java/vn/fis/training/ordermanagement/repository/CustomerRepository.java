package vn.fis.training.ordermanagement.repository;

import vn.fis.training.ordermanagement.model.Order;

import java.util.List;

public interface CustomerRepository{
    List<Order> findAllOrdersUsingCustomerRepository();
}
