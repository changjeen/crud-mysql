package com.example.crudmysql.repositroy;

import com.example.crudmysql.domain.user.Designer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DesignerRepository extends JpaRepository<Designer, Long> {
    List<Designer> findByShop_id(Long shop_id);
}
