package com.example.crudmysql.repositroy;

import com.example.crudmysql.domain.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
