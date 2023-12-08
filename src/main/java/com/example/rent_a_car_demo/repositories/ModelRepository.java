package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Integer> {

    Model findByName(String name);
    Model findByFuelTypeAndEnginePower(String fuelType, String enginePower);
    @Query("select Count(m.fuelType) from Model m where m.fuelType = :fuelType ")
    Integer getModelList(String fuelType);

    @Query("select Count(m.fuelType)  from Model m where m.fuelType = :fuelType having Count(m.fuelType) > : value  ")
    List<Integer> getModelFuelTypeCount(Integer value);

}
