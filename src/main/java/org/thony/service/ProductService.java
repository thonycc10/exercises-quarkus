package org.thony.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.thony.model.Product;

import java.util.List;

@ApplicationScoped
public class ProductService {
    public final List<Product> products = List.of(
      new Product(1, "Laptop", 2000, true),
      new Product(2, "Laptop 1", 3000, true),
      new Product(3, "Laptop 2", 4000, false),
      new Product(4, "Laptop 3", 5000, true),
      new Product(5, "Laptop 4", 6000, false),
      new Product(6, "Laptop 5", 7000, true)
    );

    public List<Product> getProducts() {
        return products;
    }
}
