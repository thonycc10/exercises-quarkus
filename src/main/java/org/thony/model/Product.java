package org.thony.model;

public record Product (
        long id,
        String name,
        double price,
        boolean isActive
){
}
