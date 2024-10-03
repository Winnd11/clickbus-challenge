package org.william.clickbus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.william.clickbus.entites.City;
import org.william.clickbus.repositories.CityRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/clickbus")
public class CityController {

    @Autowired
    CityRepository repository;

    @GetMapping(value = "/cityall")
    public List<City> getAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/cityid/{id}")
    public City findById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

//    @GetMapping(value = "/cityname/{name}")
//    public City findByName(@PathVariable String name) {
//    }

    @PostMapping(value = "/citycreate")
    public City createCity(@RequestBody City city) {
        return repository.save(city);
    }
}
