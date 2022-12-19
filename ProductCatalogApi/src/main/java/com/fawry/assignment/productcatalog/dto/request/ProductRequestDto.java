package com.fawry.assignment.productcatalog.dto.request;

import com.fawry.assignment.productcatalog.repository.entity.Category;
import com.fawry.assignment.productcatalog.repository.entity.Variant;
import lombok.Data;


import java.util.List;

@Data
public class ProductRequestDto {
    private Long id;
    private String nameAr;
    private String nameEn;
    private Byte[] image;
    private int buyingCount;
    private List<Variant> variants;
    private Category category;

}
