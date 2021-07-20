package com.example.exbackendgradle.reponsitory;

import com.example.exbackendgradle.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p from Product  p where p.name like %?1%")
    List<Product> findByNameMyContaining(String name);

    @Query(value = "select p from Product  p where p.price >= ?1 and  p.price <= ?2")
    List<Product> findByPriceInRange(double price1, double price2);
}