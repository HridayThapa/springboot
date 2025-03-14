package com.wipro.micro.service;

import java.util.List;
import java.util.Optional;

import com.wipro.micro.entity.Product;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    Product saveProduct(Product product);
    Optional<Product> updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}

