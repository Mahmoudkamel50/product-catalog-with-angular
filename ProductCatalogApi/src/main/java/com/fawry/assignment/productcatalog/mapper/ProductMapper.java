package com.fawry.assignment.productcatalog.mapper;

import com.fawry.assignment.productcatalog.dto.request.ProductRequestDto;
import com.fawry.assignment.productcatalog.dto.response.ProductResponseDto;
import com.fawry.assignment.productcatalog.repository.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toProduct(ProductRequestDto requestDto);


    default ProductResponseDto toResponseDto(Product product){
        if (product == null) throw new RuntimeException("cannot map null to ProductResponseDto");
        else{
            ProductResponseDto responseDto = new ProductResponseDto();
            responseDto.setId(product.getId());
            responseDto.setNameEn(product.getNameEn());
            responseDto.setNameAr(product.getNameAr());
            responseDto.setImage(product.getImage());
            responseDto.setBuyingCount(product.getBuyingCount());
            responseDto.setCategory(CategoryMapper.INSTANCE.toResponseDto(product.getCategory()));
            if (product.getVariants() != null) responseDto.setVariants(product.getVariants().stream().map(VariantMapper.INSTANCE::toResponseDto).toList());
            return responseDto;
        }
    }
}
