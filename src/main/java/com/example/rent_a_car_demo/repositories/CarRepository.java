package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.dtos.responses.GetCarResponse;
import com.example.rent_a_car_demo.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {


    List<Car> findByColorIgnoreCase(String color);

    List<Car> findByYearAndColorOrderByRentalFeeDesc(Integer year, String color);

    @Query("SELECT new  com.example.rent_a_car_demo.dtos.responses.GetCarResponse(c.year, c.color, c.rentalFee, c.licencePlate," +
            "new com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetCarTypeResponse(ct.name))" +
            " FROM Car c LEFT JOIN c.carType ct WHERE (c.year = :year AND c.color = :color) OR c.rentalFee < :rentalFee")
    List<GetCarResponse> findByYearAndColorOrRentalFeeLessThan(Integer year, String color, Double rentalFee);

    @Query("SELECT new  com.example.rent_a_car_demo.dtos.responses.GetCarResponse(c.year, c.color, c.rentalFee, c.licencePlate," +
            "new com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetCarTypeResponse(ct.name))" +
            " FROM Car c LEFT JOIN c.carType ct WHERE c.rentalFee BETWEEN :minRentalFee AND :maxRentalFee")
    List<GetCarResponse> findByRentalFeeBetween(Double minRentalFee, Double maxRentalFee);

    boolean existsByLicencePlate(String licancePlate);
}
