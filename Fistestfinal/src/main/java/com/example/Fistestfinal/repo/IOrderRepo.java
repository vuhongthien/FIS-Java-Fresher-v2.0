package com.example.Fistestfinal.repo;

import com.example.Fistestfinal.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepo extends JpaRepository<Order, Long > {
}
