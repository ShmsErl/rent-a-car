package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.dtos.requests.AddCarTypeRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateCarTypeRequest;
import com.example.rent_a_car_demo.dtos.responses.GetCarTypeListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetCarTypeResponse;
import com.example.rent_a_car_demo.services.abstracts.CarTypeService;
import com.example.rent_a_car_demo.services.concretes.CarTypeManager;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cartypes")
public class CarTypeController {
    private final CarTypeService carTypeService;


    @GetMapping("/getall")
    public List<GetCarTypeListResponse> getAllTypes() {
        return carTypeService.getAllTypes();
    }

    @GetMapping("/get")
    public GetCarTypeResponse getCarTypeById(@RequestParam(value = "id") Integer id) {
        return carTypeService.getCarTypeById(id);
    }

    @PostMapping("/add")
    public String saveCarType(@Valid  @RequestBody AddCarTypeRequest addCarTypeRequest) throws Exception {
        return carTypeService.saveCarType(addCarTypeRequest);
    }

    @PutMapping()
    public String updateCarType(@Valid @RequestBody UpdateCarTypeRequest updateCarTypeRequest) throws Exception {
       return carTypeService.updateCarType(updateCarTypeRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteCarType(@PathVariable Integer id) throws Exception {
       return carTypeService.deleteCarType(id);
    }
}
