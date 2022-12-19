package com.fawry.assignment.productcatalog.mapper;

import com.fawry.assignment.productcatalog.dto.request.CategoryRequestDto;
import com.fawry.assignment.productcatalog.dto.response.CategoryResponseDto;
import com.fawry.assignment.productcatalog.repository.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category toCategory(CategoryRequestDto requestDto);

    CategoryResponseDto toResponseDto(Category category);

}
