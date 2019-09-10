package com.example.crudmysql.rest;

import com.example.crudmysql.domain.Member;
import com.example.crudmysql.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/member")
public class MemberAPI {
    @Autowired
    MemberService memberService;

    @GetMapping
    public ResponseEntity<List<Member>> findAll() { return ResponseEntity.ok(memberService.findAll());}

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Member member) {
        return ResponseEntity.ok(memberService.save(member));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> findById(@PathVariable Long id) {
        Optional<Member> member = memberService.findById(id);
        if(!member.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(member.get());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Member> update(@PathVariable Long id, @Valid @RequestBody Member member) {
        if (!memberService.findById(id).isPresent()) {
//            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(memberService.save(member));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!memberService.findById(id).isPresent()) {
//            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        memberService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
