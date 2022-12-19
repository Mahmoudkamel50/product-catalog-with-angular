package com.fawry.assignment.productcatalog.controller;

import com.fawry.assignment.productcatalog.dto.request.BuyingRequestDto;
import com.fawry.assignment.productcatalog.dto.request.OrderRequestDto;
import com.fawry.assignment.productcatalog.dto.response.OrderResponseDto;
import com.fawry.assignment.productcatalog.exception.ItemNotAvailableException;
import com.fawry.assignment.productcatalog.exception.MethodNotAllowedException;
import com.fawry.assignment.productcatalog.mapper.OrderMapper;
import com.fawry.assignment.productcatalog.repository.entity.Order;
import com.fawry.assignment.productcatalog.repository.entity.Variant;
import com.fawry.assignment.productcatalog.service.OrderService;
import com.fawry.assignment.productcatalog.service.ProductService;
import com.fawry.assignment.productcatalog.service.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private VariantService variantService;
    @Autowired
    private ProductService productService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponseDto addOrder(@RequestBody OrderRequestDto requestDto){
        Order order = OrderMapper.INSTANCE.toOrder(requestDto);
        List<Variant> variants = order.getVariants().stream().map(variant -> variantService.getById(variant.getId())).toList();
        order.setVariants(variants);
        order.setTotalPrice(order.getVariants().stream().mapToDouble(Variant::getPrice).sum());
        variants.forEach(product -> product.setOrders(List.of(order)));
        order.setBought(true);
        return OrderMapper.INSTANCE.toResponseDto(this.orderService.add(order));
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderResponseDto getOrder(@PathVariable Long id){
        return OrderMapper.INSTANCE.toResponseDto(this.orderService.getOrderById(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponseDto> getAllOrders(){
        List<OrderResponseDto> responseDtos = new ArrayList<>();
        this.orderService.getAll().forEach(order -> responseDtos.add(OrderMapper.INSTANCE.toResponseDto(order)));
        return responseDtos;
    }

    @GetMapping("orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponseDto> getAllOrdersForCustomer(@PathVariable Long id){
        List<OrderResponseDto> responseDtos = new ArrayList<>();
        this.orderService.getAllByCustomerId(id).forEach(order -> responseDtos.add(OrderMapper.INSTANCE.toResponseDto(order)));
        return responseDtos;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public OrderResponseDto placeOrder(@RequestBody BuyingRequestDto requestDto){
        // get Order from the database
        Order order = orderService.getOrderById(requestDto.getOrder().getId());

        // check if this order is not bought before
        if(order.isBought()) throw new MethodNotAllowedException("cannot buy order that has been already bought");

        // check if the product is available to buy
        order.getVariants().forEach(
                variant -> {
                    if (variant.getQuantity() == 0) {
                        throw new ItemNotAvailableException("The Item You are looking for is not available at this moment");
                    }
                }
        );
        // increase the popularity of each product
        order.getVariants().forEach(variant -> variant.getProduct().setBuyingCount(variant.getProduct().getBuyingCount() + 1));

        // decrease the quantity of each product by one

        order.getVariants().forEach(variant -> variant.setQuantity(variant.getQuantity() - 1));

        order.setBought(true);
        // save the changes to the database
        this.orderService.updateOrder(order);
        order.getVariants().forEach(
                variant -> {
                    productService.updateProduct(variant.getProduct());
                    variantService.updateVariant(variant);
                }
        );
        return OrderMapper.INSTANCE.toResponseDto(order);
    }
}
