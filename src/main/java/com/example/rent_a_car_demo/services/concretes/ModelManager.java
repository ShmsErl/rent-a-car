package com.example.rent_a_car_demo.services.concretes;

import com.example.rent_a_car_demo.dtos.GetModelFuelTypeCountResponse;
import com.example.rent_a_car_demo.dtos.requests.AddModelRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateModelRequest;
import com.example.rent_a_car_demo.dtos.responses.GetBrandResponse;
import com.example.rent_a_car_demo.dtos.responses.GetModelListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetModelResponse;
import com.example.rent_a_car_demo.models.Brand;
import com.example.rent_a_car_demo.models.Model;
import com.example.rent_a_car_demo.repositories.ModelRepository;
import com.example.rent_a_car_demo.services.abstracts.ModelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;


    public List<GetModelListResponse> getModelList() {
        List<Model> models = this.modelRepository.findAll();
        List<GetModelListResponse> responses = new ArrayList<>();

        for (Model model : models) {
            GetModelListResponse response = new GetModelListResponse();

            response.setName(model.getName());
            response.setEnginePower(model.getEnginePower());
            response.setFuelType(model.getFuelType());
            response.setBrand(new GetBrandResponse(model.getBrand().getName()));

            responses.add(response);

        }
        return responses;

    }

    public GetModelResponse getModelResponse(int id) throws Exception {
        GetModelResponse response = new GetModelResponse();
        Model model1 = modelRepository.findById(id).orElseThrow(() -> new Exception("Could not find Brand"));

        response.setName(model1.getName());
        response.setEnginePower(model1.getEnginePower());
        response.setFuelType(model1.getFuelType());
        response.setBrand(new GetBrandResponse(model1.getBrand().getName()));


        return response;


    }


    public String createModel(AddModelRequest request) throws Exception {
        boolean result = this.modelRepository.existsByName(request.getName());
        if(result){

            throw  new Exception("Already exists Model Name");
        }


        Model model = new Model();
        model.setName(request.getName());
        model.setEnginePower(request.getEnginePower());
        model.setFuelType(request.getFuelType());
        model.setBrand(request.getBrand());

        this.modelRepository.save(model);

        return "Transactional Successfully Created Model";
    }

    public String updateModel(int id, UpdateModelRequest request) throws Exception {
        Model model1 = modelRepository.findById(id).orElseThrow(() -> new Exception("Could not find Brand"));

        model1.setName(request.getName());
        model1.setFuelType(request.getFuelType());
        model1.setEnginePower(request.getEnginePower());
        model1.setBrand(request.getBrand());

        this.modelRepository.save(model1);

        return "Transactional Successfully Updated Model";

    }

    @Override
    public GetModelResponse findByName(String name) {

        Model model = this.modelRepository.findByName(name);
        GetModelResponse response = new GetModelResponse();

        response.setName(model.getName());
        response.setFuelType(model.getFuelType());
        response.setEnginePower(model.getEnginePower());
        response.setBrand(new GetBrandResponse(model.getBrand().getName()));
        return response;
    }

    @Override
    public List<GetModelListResponse> findByFuelTypeAndEnginePower(String fuelType, String enginePower) {

        List<Model> models = this.modelRepository.findByFuelTypeAndEnginePower(fuelType, enginePower);
        List<GetModelListResponse> responses = new ArrayList<>();
        GetModelListResponse response = new GetModelListResponse();

        models.forEach(model -> {
            response.setName(model.getName());
            response.setFuelType(model.getFuelType());
            response.setEnginePower(model.getEnginePower());
            response.setBrand(new GetBrandResponse(model.getBrand().getName()));

            responses.add(response);

        });
        return responses;
    }

    public String deleteByModel(int id) throws Exception {

        this.modelRepository.findById(id).orElseThrow(() -> new Exception("Could not"));

        this.modelRepository.deleteById(id);
        return "Deletion successful";
    }

    @Override
    public List<GetModelFuelTypeCountResponse> getModelFuelTypeCount(Long value) {


        return this.modelRepository.getByFuelType(value);
    }

    @Override
    public Long getModelList(String fuelType) {
        return this.modelRepository.getModelList(fuelType);
    }
}
