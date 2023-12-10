package com.example.rent_a_car_demo.services.abstracts;

import com.example.rent_a_car_demo.dtos.requests.AddCarTypeRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateCarTypeRequest;
import com.example.rent_a_car_demo.dtos.responses.GetCarTypeListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetCarTypeResponse;

import java.util.List;

public interface CarTypeService {
    List<GetCarTypeListResponse> getAllTypes();
    GetCarTypeResponse getCarTypeById(int id);
    String saveCarType(AddCarTypeRequest addCarTypeRequest) throws Exception;
    String updateCarType(UpdateCarTypeRequest updateCarTypeRequest) throws Exception;
    String deleteCarType(int id) throws Exception;
}
