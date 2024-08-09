package com.stage.insertMarks.controller;

import com.stage.insertMarks.entity.Module;
import com.stage.insertMarks.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modules")
@CrossOrigin(origins = "http://localhost:3000/")
public class ModuleController {

    @Autowired
    private ModuleRepository moduleRepository;
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping
    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/{id}")
    public ResponseEntity<Module> getModuleById(@PathVariable Integer id) {
        return moduleRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

