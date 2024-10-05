package org.william.clickbus.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
        return repository.findAllCities();
    }

    @GetMapping(value = "/cityid/{id}")
    public ResponseEntity<City> findById(@PathVariable Long id) {
        Optional<City> result = Optional.ofNullable(repository.findByCityId(id));

        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping(value = "/cityname/{name}")
    public City findByName(@PathVariable String name) {
        return repository.findCityByName(name);
    }

    @PostMapping(value = "/citycreate")
    public City createCity(@RequestBody City city) {
        return repository.save(city);
    }
}
