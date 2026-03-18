package com.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getByCategory(String category) {
        return repo.findByCategory(category);
    }

    public List<Product> getByPriceRange(double min, double max) {
        return repo.findByPriceBetween(min, max);
    }

    public List<Product> getSorted() {
        return repo.getProductsSortedByPrice();
    }

    public List<Product> getExpensive(double price) {
        return repo.getExpensiveProducts(price);
    }
}