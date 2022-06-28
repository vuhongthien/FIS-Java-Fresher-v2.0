package com.example.Fistestfinal.service;

import com.example.Fistestfinal.model.Product;

public interface I_ProductService {
    Product findById(Long productId);
    Product update(Product product);
}
