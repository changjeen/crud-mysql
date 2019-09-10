package com.example.crudmysql.rest;

import com.example.crudmysql.domain.Order;
import com.example.crudmysql.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/order")
public class OrderAPI {
    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity createOrder(@RequestParam("memberId") Long memberId,
                                      @RequestParam("count") int count) {
        return ResponseEntity.ok(orderService.order(memberId,count));
    }
}
