package com.example.crudmysql.rest;

import com.example.crudmysql.domain.Member;
import com.example.crudmysql.domain.user.Customer;
import com.example.crudmysql.service.CustomerService;
import com.example.crudmysql.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerAPI {
    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> findAll() { return ResponseEntity.ok(customerService.findAll());}

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.save(customer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if(!customer.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(customer.get());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @Valid @RequestBody Customer customer) {
        if (!customerService.findById(id).isPresent()) {
//            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(customerService.save(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!customerService.findById(id).isPresent()) {
//            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        customerService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
