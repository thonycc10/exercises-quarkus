package org.thony.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class Product extends PanacheEntity {
    public String name;
    public BigDecimal price;
    public boolean isActive;
}
