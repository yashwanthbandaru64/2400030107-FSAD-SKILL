package com.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    // a. Category search
    // GET http://localhost:8080/products/category/{category}
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }

    // b. Price filter
    // GET http://localhost:8080/products/filter?min=100&max=500
    @GetMapping("/filter")
    public List<Product> getByPrice(@RequestParam double min,
                                   @RequestParam double max) {
        return service.getByPriceRange(min, max);
    }

    // c. Sorted by price
    // GET http://localhost:8080/products/sorted
    @GetMapping("/sorted")
    public List<Product> getSorted() {
        return service.getSorted();
    }

    // d. Expensive products
    // GET http://localhost:8080/products/expensive/{price}
    @GetMapping("/expensive/{price}")
    public List<Product> getExpensive(@PathVariable double price) {
        return service.getExpensive(price);
    }
}