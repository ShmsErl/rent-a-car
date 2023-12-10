package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.models.CarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarTypeRepository extends JpaRepository<CarType, Integer> {

    boolean existsByName(String name);


}
