package org.william.clickbus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.william.clickbus.entites.City;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    // Get all cities
    @Query(value = "SELECT * FROM tb_city", nativeQuery = true)
    List<City> findAllCities();

    // Get city by id
    @Query(value = "SELECT * FROM tb_city WHERE id = :id", nativeQuery = true)
    City findByCityId(@Param("id") Long id);

    // Get city by name
    @Query(value = "SELECT * FROM tb_city WHERE name = :name", nativeQuery = true)
    City findCityByName(@Param("name") String name);

    // Update city
    @Transactional
    @Modifying
    @Query(value = "UPDATE tb_city SET name = :name WHERE id = :id", nativeQuery = true)
    void updateCityByName(@Param("id") Long id, @Param("name") String name);

    // Delete city
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM tb_city WHERE id = :id", nativeQuery = true)
    void deleteCity(@Param("id") Long id);

}