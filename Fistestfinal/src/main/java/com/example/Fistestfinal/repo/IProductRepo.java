package com.example.Fistestfinal.repo;

import com.example.Fistestfinal.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepo extends JpaRepository<Product,Long> {
}
