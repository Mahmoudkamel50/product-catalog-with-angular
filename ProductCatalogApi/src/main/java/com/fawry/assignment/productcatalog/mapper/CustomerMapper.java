package com.fawry.assignment.productcatalog.mapper;

import com.fawry.assignment.productcatalog.dto.request.CustomerRequestDto;
import com.fawry.assignment.productcatalog.dto.response.CustomerResponseDto;
import com.fawry.assignment.productcatalog.repository.entity.Customer;
import com.fawry.assignment.productcatalog.repository.entity.Login;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerResponseDto toResponseDto(Login login, Customer customer);

    Customer toCustomer(CustomerRequestDto requestDto);

    Login toLogin(CustomerRequestDto requestDto);
}
