package com.oocl.demo.controller;

import com.oocl.demo.model.Company;
import com.oocl.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository repository;

    @PostMapping
    public Company create(@RequestBody Company company) {
        return repository.save(company);
    }

    @GetMapping
    public List<Company> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Company getById(@PathVariable int id) {
        Optional<Company> optional = repository.findById(id);
        return optional.isPresent()? optional.get() : optional.orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        repository.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody Company company) {
        repository.save(company);
    }

}
