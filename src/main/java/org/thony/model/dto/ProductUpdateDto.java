package org.thony.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductUpdateDto {
    Long id;
    BigDecimal price;
    boolean isActive;
}
