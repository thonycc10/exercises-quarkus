package org.thony.model.dto;

import org.thony.model.Product;

import java.util.List;

public record ProductEnableDto (
        List<Product> enable,
        List<Product> disable) {
}
