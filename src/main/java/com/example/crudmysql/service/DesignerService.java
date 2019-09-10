package com.example.crudmysql.service;

import com.example.crudmysql.domain.Shop;
import com.example.crudmysql.domain.user.Designer;
import com.example.crudmysql.exception.NotExistMemberException;
import com.example.crudmysql.repositroy.DesignerRepository;
import com.example.crudmysql.repositroy.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesignerService {

    @Autowired
    DesignerRepository designerRepository;
    @Autowired
    ShopRepository shopRepository;

    public List<Designer> findAll() {return designerRepository.findAll();}

    public Optional<Designer> findById(Long id) {
        return designerRepository.findById(id);
    }

    public Designer save(Designer designer) {
        return designerRepository.save(designer);
    }

    public void deleteById(Long id) {
        designerRepository.deleteById(id);
    }
}
