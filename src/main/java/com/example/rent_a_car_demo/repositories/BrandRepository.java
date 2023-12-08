package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.dtos.responses.GetBrandResponse;
import com.example.rent_a_car_demo.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    List<Brand> findByNameStartingWith(String name);
    List<Brand> findByNameEndingWith(String name);
    boolean existsByName(String name);
    @Query("SELECT DISTINCT new com.example.rent_a_car_demo.dtos.responses.GetBrandResponse(b.name)" +
            "FROM Brand b Where b.name = :name")
    List<GetBrandResponse> findDistinctByName(String name);
    @Query("SELECT new com.example.rent_a_car_demo.dtos.responses.GetBrandResponse(b.name)" +
            " FROM Brand b WHERE LENGTH(b.name) > :length")
    List<GetBrandResponse> findByNameLengthGreaterThan(int length);
}
