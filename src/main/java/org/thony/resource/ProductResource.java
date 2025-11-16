package org.thony.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.thony.model.Product;
import org.thony.model.dto.ProductDto;
import org.thony.service.ProductService;

import java.util.Comparator;
import java.util.List;

@Path( "/products")
public class ProductResource {

    @Inject
    ProductService service;

    @GET
    @Path("/enable")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getEnableProducts() {
        return service.products
                .stream()
                .filter(Product::isActive)
                .toList();
    }

    @GET
    @Path("/map")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getMapProducts() {
        return service.products.stream().map(Product::name).toList();
    }

    @GET
    @Path("/sort")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getSoutedProducts() {
        return service.products.stream().sorted(Comparator.comparingDouble(Product::price)).toList();
    }

    @GET
    @Path("/max")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getMaxProduct() {
        return service.products.stream().max(Comparator.comparingDouble(Product::price)).orElse(null);
    }

    @GET
    @Path("/productdto")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDto> getDtoProduct() {
        return service.products.stream().map(product -> new ProductDto(product.name(), product.price())).toList();
    }

    @GET
    @Path("/filter")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDto> getFilterProducts(
            @QueryParam("min") double minPrice,
            @QueryParam("max") double maxPrice,
            @QueryParam("order") String order
    ) {
        return service.products.stream()
                .filter(product -> product.price() >= minPrice && product.price() <= maxPrice)
                .sorted((a, b) -> order.equals("desc")
                        ? Double.compare(b.price(), a.price())
                        : Double.compare(a.price(), b.price()))
                .map(product -> new ProductDto(product.name(), product.price()))
                .toList();
    }

}