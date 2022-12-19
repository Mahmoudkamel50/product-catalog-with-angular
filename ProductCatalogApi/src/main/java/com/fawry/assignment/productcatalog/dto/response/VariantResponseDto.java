package com.fawry.assignment.productcatalog.dto.response;

import lombok.Data;


@Data
public class VariantResponseDto {


    private Long id;
    private String nameAr;
    private String nameEn;
    private Byte[] image;
    private String type;
    private int quantity;
    private double price;
    private int limit;
}
