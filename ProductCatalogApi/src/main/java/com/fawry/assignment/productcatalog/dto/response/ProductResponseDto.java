package com.fawry.assignment.productcatalog.dto.response;


import lombok.Data;

import java.util.List;

@Data
public class ProductResponseDto {

    private Long id;
    private String nameAr;
    private String nameEn;
    private Byte[] image;
    private int buyingCount;
    private List<VariantResponseDto> variants;
    private CategoryResponseDto category;
}
