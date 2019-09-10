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
public class ShopService {
    @Autowired
    ShopRepository shopRepository;
    @Autowired
    DesignerRepository designerRepository;

    public Long createShop(Shop p_shop, Long designerId){
        // 디자이너 조회
        Optional<Designer> designer = designerRepository.findById(designerId);
        if(!designer.isPresent()){
            throw new NotExistMemberException("디자이너 정보가 없습니다.");
        }
        Shop shop = Shop.createShop(p_shop, designer.get());
        shopRepository.save(shop);
        return shop.getId();
    }

    public List<Shop> findAll() {return shopRepository.findAll();}

    public Optional<Shop> findById(Long id) {
        return shopRepository.findById(id);
    }

    public Shop save(Shop shop) {
        return shopRepository.save(shop);
    }

    public void deleteById(Long id) {
        shopRepository.deleteById(id);
    }
}
