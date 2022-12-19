package com.fawry.assignment.productcatalog.mapper;

import com.fawry.assignment.productcatalog.dto.request.OrderRequestDto;
import com.fawry.assignment.productcatalog.dto.response.OrderResponseDto;
import com.fawry.assignment.productcatalog.repository.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);


    Order toOrder(OrderRequestDto requestDto);



    default OrderResponseDto toResponseDto(Order order){
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setCustomerName(order.getCustomer().getName());
        responseDto.setTotalPrice(order.getTotalPrice());
        responseDto.setVariantNames(order.getVariants().stream().map(variant -> variant.getProduct().getNameEn()).toList());
        responseDto.setBought(order.isBought());
        return responseDto;
    }
}
