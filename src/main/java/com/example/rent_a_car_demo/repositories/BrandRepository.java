package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.dtos.responses.GetBrandResponse;
import com.example.rent_a_car_demo.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    Brand findByName(String name );

    List<Brand> findByNameStartingWith(String names);

    @Query("select new com.example.rent_a_car_demo.dtos.responses.GetBrandResponse(b.name) from Brand b where b.name like  %:name%")
    GetBrandResponse getBrandByName(String name);

    @Query("select new com.example.rent_a_car_demo.dtos.responses.GetBrandResponse(b.name) from Brand b where length(b.name) > :name")
   List< GetBrandResponse> getBrandByNameIn( int  name);
}
