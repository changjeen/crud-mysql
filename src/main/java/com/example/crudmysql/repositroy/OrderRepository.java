package com.example.crudmysql.repositroy;

import com.example.crudmysql.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
