package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.dtos.responses.GetCarResponse;
import com.example.rent_a_car_demo.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {


    List<Car> findByColorIgnoreCase(String color);

    List<Car> findByYearAndColorOrderByRentalFeeDesc(Integer year, String color);

    //yıl ve renge göre ya da kiralama ücreti tutardan fazla(lessthan)

    @Query("select new com.example.rent_a_car_demo.dtos.responses.GetCarResponse(c.year,c.color,c.rentalFee,c.licencePlate, new com.example.rent_a_car_demo.dtos.responses.GetCarTypeResponse(c.carType.name)) " +
            "from Car c where c.year = : year and c.color = : color or c.rentalFee = : rentalFee  ")
    List<GetCarResponse> jkkjhkj(String color, int year, double rentalFee);


    @Query("select new com.example.rent_a_car_demo.dtos.responses.GetCarResponse(c.year,c.color,c.rentalFee,c.licencePlate, " +
            "new com.example.rent_a_car_demo.dtos.responses.GetCarTypeResponse(c.carType.name)) from Car c  where c.rentalFee between  :minRentalFee and :maxRentalFee")
    List<GetCarResponse> getByModelRentalFeeBetween(double minRentalFee, double maxRentalFee);



    boolean existsByLicencePlate(String licancePlate);
}
