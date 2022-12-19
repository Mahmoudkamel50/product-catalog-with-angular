package com.fawry.assignment.productcatalog.dto.request;

import com.fawry.assignment.productcatalog.repository.entity.Product;
import lombok.Data;

@Data
public class VariantRequestDto {

    private String type;
    private int quantity;
    private double price;
    private Product product;
    private int limit;
}
