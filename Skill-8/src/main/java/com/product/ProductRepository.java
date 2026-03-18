package com.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    // ===== Derived Query Methods =====
    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min, double max);

    // ===== JPQL Queries =====

    // Sorting by price
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> getProductsSortedByPrice();

    // Products above given price
    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> getExpensiveProducts(double price);

    // Products by category
    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> getByCategoryJPQL(String category);
}