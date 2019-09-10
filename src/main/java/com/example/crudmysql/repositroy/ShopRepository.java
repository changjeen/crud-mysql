package com.example.crudmysql.repositroy;

import com.example.crudmysql.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
