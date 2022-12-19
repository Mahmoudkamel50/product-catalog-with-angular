package com.fawry.assignment.productcatalog.dto.request;

import com.fawry.assignment.productcatalog.repository.entity.Customer;
import com.fawry.assignment.productcatalog.repository.entity.Variant;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {
    private Customer customer;
    private List<Variant> variants;
}
