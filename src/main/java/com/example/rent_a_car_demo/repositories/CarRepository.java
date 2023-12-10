package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.dtos.responses.GetCarListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetCarResponse;
import com.example.rent_a_car_demo.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Integer> {


    List<Car> findByColorIgnoreCase(String color);

    List<Car> findByYearAndColorOrderByRentalFeeDesc(Integer year, String color);

    //yıl ve renge göre ya da kiralama ücreti tutardan fazla(lessthan)

    @Query(value = "select new com.example.rent_a_car_demo.dtos.responses.GetCarListResponse(c.year,c.color,c.rentalFee,c.licencePlate," +
            " new com.example.rent_a_car_demo.dtos.responses.GetModelResponse(c.model.name,c.model.fuelType,c.model.enginePower," +
            " new com.example.rent_a_car_demo.dtos.responses.GetBrandResponse(c.model.brand.name))" +
            ",new com.example.rent_a_car_demo.dtos.responses.GetCarTypeResponse(c.carType.name)) " +
            "from Car c where  c.year = :year and c.color = :color and c.rentalFee = :rentalFee  ")
    List<GetCarListResponse> searchByYearAndColorOrRentalFee(String color, Integer year, Double rentalFee);




    @Query("select new com.example.rent_a_car_demo.dtos.responses.GetCarListResponse(c.year,c.color,c.rentalFee,c.licencePlate, new com.example.rent_a_car_demo.dtos.responses.GetModelResponse(c.model.name,c.model.fuelType,c.model.enginePower, new com.example.rent_a_car_demo.dtos.responses.GetBrandResponse(c.model.brand.name)),new com.example.rent_a_car_demo.dtos.responses.GetCarTypeResponse(c.carType.name)) from Car c  where c.rentalFee between  :minRentalFee and :maxRentalFee")
    List<GetCarListResponse> getByModelRentalFeeBetween(double minRentalFee, double maxRentalFee);



    boolean existsByLicencePlate(String licancePlate);
}
