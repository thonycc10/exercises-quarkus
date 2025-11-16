package org.thony.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.thony.model.Product;
import org.thony.model.dto.ProductDto;
import org.thony.model.dto.ProductEnableDto;
import org.thony.repository.ProductRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository repository;

    public List<Product> all() {
        return repository.listAll();
    }

    public List<ProductDto> enable() {
        return repository.listAll().stream()
                .map(product -> new ProductDto(
                        product.id,
                        product.name,
                        product.price
                ))
                .toList();
    }

    public List<Product> filterByPrice(BigDecimal minPrice, BigDecimal maxPrice) {
        return repository.listAll().stream()
                .filter(product -> minPrice.compareTo(product.price) <= 0 && maxPrice.compareTo(product.price) >= 0 )
                .sorted(Comparator.comparing(a -> a.price))
                .toList();
    }

    public BigDecimal averagePrice() {
        List<Product> products = repository.listAll();
        return products.stream()
                .map(product -> product.price)
                .reduce(BigDecimal::add)
                .map(sum -> sum.divide(BigDecimal.valueOf(products.size()), 2, RoundingMode.HALF_UP))
                .orElse(BigDecimal.ZERO);
    }

    public Product save(Product product) {
        repository.persist(product);
        return product;
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }

    public boolean delete(Long id) {
        return repository.deleteById(id);
    }

    public Map<Boolean, List<Product>> groupByEnable() {
        return repository.listAll().stream()
                .collect(Collectors.groupingBy(p -> p.isActive));
    }
    
    public ProductEnableDto groupProduct() {
        Map<Boolean, List<Product>> mapProductoEnable = groupByEnable();
        return new ProductEnableDto(
                mapProductoEnable.getOrDefault(true, List.of()),
                mapProductoEnable.getOrDefault(false, List.of())
        );
    }

}
