package com.example.rent_a_car_demo.services.abstracts;

import com.example.rent_a_car_demo.dtos.GetModelFuelTypeCountResponse;
import com.example.rent_a_car_demo.dtos.requests.AddModelRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateModelRequest;
import com.example.rent_a_car_demo.dtos.responses.GetModelListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetModelResponse;
import com.example.rent_a_car_demo.models.Model;

import java.util.List;
import java.util.Map;

public interface ModelService {
    List<GetModelListResponse> getModelList();

    GetModelResponse getModelResponse(int id) throws Exception;

    String createModel(AddModelRequest request) throws Exception;

    String updateModel(int id, UpdateModelRequest request) throws Exception;

    String deleteByModel(int id) throws Exception;

    GetModelResponse  findByName(String name);

    List<GetModelListResponse> findByFuelTypeAndEnginePower(String fuelType, String enginePower);

    List<GetModelFuelTypeCountResponse> getModelFuelTypeCount(Long value);

    Long getModelList(String fuelType);
}
