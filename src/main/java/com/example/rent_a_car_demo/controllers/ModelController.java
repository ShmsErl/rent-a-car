package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.dtos.GetModelFuelTypeCountResponse;
import com.example.rent_a_car_demo.dtos.requests.AddModelRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateModelRequest;
import com.example.rent_a_car_demo.dtos.responses.GetModelListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetModelResponse;
import com.example.rent_a_car_demo.services.abstracts.ModelService;
import com.example.rent_a_car_demo.services.concretes.ModelManager;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/models")
@AllArgsConstructor
public class ModelController {

    private ModelService modelService;



    @GetMapping("/getall")
    public List<GetModelListResponse > getModelList() {

        return  this.modelService.getModelList();
    }
    @GetMapping("{id}")
    public GetModelResponse getModelResponse(@PathVariable  int id) throws Exception {

    return this.modelService.getModelResponse(id);
    }
    @PostMapping("/create")
        public String createModel(@Valid  @RequestBody AddModelRequest model) throws Exception {

        return this.modelService.createModel(model);
    }

    @PutMapping("/update/{id}")
    public String updateModel(@Valid @PathVariable int id, @RequestBody UpdateModelRequest model) throws Exception {

        return this.modelService.updateModel(id, model);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteModel(@PathVariable int id) throws Exception {

        return this.modelService.deleteByModel(id);
    }
    @GetMapping("/findbyname")
    public GetModelResponse findByName(@RequestParam String name) {

        return this.modelService.findByName(name);
    }
    @GetMapping("/findbyfueltypeandenginepower")
    public List<GetModelListResponse> findByFuelTypeAndEnginePower(@RequestParam String fuelType, String enginePower) {

        return this.modelService.findByFuelTypeAndEnginePower(fuelType,enginePower);
    }
    @GetMapping("/fueltypecount")
    public Long getFuelTypeCount(@RequestParam String fuelType){

        return this.modelService.getModelList(fuelType);
    }
    @GetMapping("/COUNT")
    public List<GetModelFuelTypeCountResponse> getCount(@RequestParam Long value){

        return this.modelService.getModelFuelTypeCount(value);
    }
}
