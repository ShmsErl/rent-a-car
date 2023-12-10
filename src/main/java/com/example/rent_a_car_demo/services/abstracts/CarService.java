package com.example.rent_a_car_demo.services.abstracts;

import com.example.rent_a_car_demo.dtos.requests.AddBrandRequest;
import com.example.rent_a_car_demo.dtos.requests.AddCarRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateBrandRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateCarRequest;
import com.example.rent_a_car_demo.dtos.responses.GetBrandListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetBrandResponse;
import com.example.rent_a_car_demo.dtos.responses.GetCarListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetCarResponse;
import com.example.rent_a_car_demo.models.Car;

import java.util.List;

public interface CarService {
    List<GetCarListResponse> getAllCars();

    GetCarResponse getCarById(int id);

    String saveCar(AddCarRequest addCarRequest) throws Exception;

    String updateCar(UpdateCarRequest updateCarRequest) throws Exception;

    String deleteCar(int id) throws Exception;

    List<GetCarListResponse> findByColorIgnoreCase(String color);

    List<GetCarListResponse> findByYearAndColorOrderByRentalFeeDesc(Integer year, String color);

    List<GetCarListResponse> searchByYearAndColorOrRentalFee(String color, Integer year, Double rentalFee);

    List<GetCarListResponse> getByModelRentalFeeBetween(double minRentalFee, double maxRentalFee);


}
