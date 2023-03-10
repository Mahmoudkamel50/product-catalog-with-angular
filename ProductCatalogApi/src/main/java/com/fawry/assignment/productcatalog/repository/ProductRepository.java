package com.fawry.assignment.productcatalog.repository;

import com.fawry.assignment.productcatalog.repository.entity.Category;
import com.fawry.assignment.productcatalog.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategory(Category category);

    List<Product> findByOrderByBuyingCountDesc();


}
