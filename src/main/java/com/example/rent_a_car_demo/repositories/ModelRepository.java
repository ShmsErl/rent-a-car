package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.dtos.GetModelFuelTypeCountResponse;
import com.example.rent_a_car_demo.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Integer> {

    Model findByName(String name);

    List<Model> findByFuelTypeAndEnginePower(String fuelType, String enginePower);

    @Query("select Count(m.fuelType) from Model m where m.fuelType = :fuelType ")
    Long getModelList(String fuelType);

    @Query("select new com.example.rent_a_car_demo.dtos.GetModelFuelTypeCountResponse(m.fuelType,count(m.fuelType)) " +
            "from Model m  group by m.fuelType having count(m.fuelType) >= :value")
    List<GetModelFuelTypeCountResponse> getByFuelType(Long value);


}
