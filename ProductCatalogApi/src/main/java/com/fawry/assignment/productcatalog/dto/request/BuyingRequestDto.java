package com.fawry.assignment.productcatalog.dto.request;

import com.fawry.assignment.productcatalog.repository.entity.Order;
import lombok.Data;

@Data
public class BuyingRequestDto {

    private Order order;
}
