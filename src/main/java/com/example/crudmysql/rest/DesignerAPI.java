package com.example.crudmysql.rest;

import com.example.crudmysql.domain.user.Designer;
import com.example.crudmysql.service.DesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/designer")
public class DesignerAPI {
    @Autowired
    DesignerService designerService;

    @GetMapping
    public ResponseEntity<List<Designer>> findAll() { return ResponseEntity.ok(designerService.findAll());}

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Designer designer) {
        return ResponseEntity.ok(designerService.save(designer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Designer> findById(@PathVariable Long id) {
        Optional<Designer> designer = designerService.findById(id);
        if(!designer.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(designer.get());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Designer> update(@PathVariable Long id, @Valid @RequestBody Designer designer) {
        if (!designerService.findById(id).isPresent()) {
//            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(designerService.save(designer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!designerService.findById(id).isPresent()) {
//            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        designerService.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
