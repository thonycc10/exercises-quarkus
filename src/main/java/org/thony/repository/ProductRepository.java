package org.thony.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.thony.model.Product;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {
}
