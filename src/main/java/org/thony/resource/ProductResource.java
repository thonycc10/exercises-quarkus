package org.thony.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.thony.model.Product;
import org.thony.model.dto.ProductDto;
import org.thony.model.dto.ProductEnableDto;
import org.thony.service.ProductService;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Path( "/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    ProductService service;

    @GET
    public List<Product> all() {
        return service.all();
    }

    @GET
    @Path("/dto")
    public List<ProductDto> listarDTO() {
        return service.enable();
    }

    @GET
    @Path("/filtrar")
    public List<Product> filtrar(@QueryParam("min") BigDecimal min,
                                  @QueryParam("max") BigDecimal max) {
        return service.filterByPrice(min, max);
    }

    @GET
    @Path("/promedio")
    public BigDecimal average() {
        return service.averagePrice();
    }

    @POST
    @Transactional
    public Product crear(Product p) {
        return service.save(p);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public boolean delete(@PathParam("id") Long id) {
        return service.delete(id);
    }

    @GET
    @Path("/group-by-enable")
    public ProductEnableDto groupByEnable() {
        return service.groupProduct();
    }

}