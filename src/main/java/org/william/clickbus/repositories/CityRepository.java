package org.william.clickbus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.william.clickbus.entites.City;

public interface CityRepository extends JpaRepository<City, Long> {
}
