package com.wipro.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.micro.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
