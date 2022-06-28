package com.example.Fistestfinal.service.impl;

import com.example.Fistestfinal.exception.ProductNotFoundException;
import com.example.Fistestfinal.model.Product;
import com.example.Fistestfinal.repo.IProductRepo;
import com.example.Fistestfinal.service.I_ProductService;
import com.example.Fistestfinal.status.StatusError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ImpProductService implements I_ProductService {
    @Autowired
    private IProductRepo iProductRepo;

    public ImpProductService(IProductRepo iProductRepo) {
        this.iProductRepo = iProductRepo;
    }

    @Override
    public Product findById(Long productId) {
        Product product = iProductRepo.findById(productId).orElseThrow(() -> {
            try {
                throw new ProductNotFoundException(
                        String.format(StatusError.ERROR_PRODUCT_NOT_FOUND + productId));
            } catch (ProductNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        log.info("Product có id  {} : {}", productId, product);
        return product;
    }

    @Override
    public Product update(Product product) {
        return iProductRepo.save(product);
    }
}
