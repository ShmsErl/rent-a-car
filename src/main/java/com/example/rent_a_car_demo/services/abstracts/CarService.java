package com.example.rent_a_car_demo.services.abstracts;

import com.example.rent_a_car_demo.dtos.requests.AddBrandRequest;
import com.example.rent_a_car_demo.dtos.requests.AddCarRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateBrandRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateCarRequest;
import com.example.rent_a_car_demo.dtos.responses.GetBrandListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetBrandResponse;
import com.example.rent_a_car_demo.dtos.responses.GetCarListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetCarResponse;

import java.util.List;

public interface CarService {
    List<GetCarListResponse> getAllCars();

    GetCarResponse getCarById(int id);

    String saveCar(AddCarRequest addCarRequest);

    String updateCar(UpdateCarRequest updateCarRequest) throws Exception;

    String deleteCar(int id) throws Exception;


}
