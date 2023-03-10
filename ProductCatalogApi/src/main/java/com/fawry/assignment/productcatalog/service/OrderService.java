package com.fawry.assignment.productcatalog.service;

import com.fawry.assignment.productcatalog.repository.entity.Order;
import com.fawry.assignment.productcatalog.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrderById(Long id){
        return this.orderRepository.findById(id).orElseThrow();
    }


    public Order add(Order order) {
        return this.orderRepository.save(order);
    }

    public List<Order> getAll() {
        return this.orderRepository.findAll();
    }

    public List<Order> getAllByCustomerId(Long id){
        return this.orderRepository.getAllByCustomerId(id);
    }

    public Order updateOrder(Order order){
        Order managedOrder = this.orderRepository.findById(order.getId()).orElseThrow();
        managedOrder.setVariants(order.getVariants());
        managedOrder.setTotalPrice(order.getTotalPrice());
        return managedOrder;
    }
}
