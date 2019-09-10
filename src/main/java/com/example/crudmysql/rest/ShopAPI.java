package com.example.crudmysql.rest;

import com.example.crudmysql.domain.Shop;
import com.example.crudmysql.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/shop")
public class ShopAPI {
    @Autowired
    ShopService shopService;

    @GetMapping
    public ResponseEntity<List<Shop>> findAll() { return ResponseEntity.ok(shopService.findAll());}

    @PostMapping("/{designerId}")
    public ResponseEntity create(@Valid @RequestBody Shop shop, @PathVariable("designerId") Long designerId) {

        return ResponseEntity.ok(shopService.createShop(shop, designerId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> findById(@PathVariable Long id) {
        Optional<Shop> shop = shopService.findById(id);
        if(!shop.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(shop.get());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Shop> update(@PathVariable Long id, @Valid @RequestBody Shop shop) {
        if (!shopService.findById(id).isPresent()) {
//            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(shopService.save(shop));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!shopService.findById(id).isPresent()) {
//            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        shopService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
