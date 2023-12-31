package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.dtos.requests.AddCarRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateCarRequest;
import com.example.rent_a_car_demo.dtos.responses.GetCarListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetCarResponse;
import com.example.rent_a_car_demo.services.abstracts.CarService;
import com.example.rent_a_car_demo.services.concretes.CarManager;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarController {

    private final CarService carService;


    @GetMapping("/getall")
    public List<GetCarListResponse> getAllCar() {
        return this.carService.getAllCars();
    }

    @GetMapping("/get")
    public GetCarResponse getCarById(@RequestParam(value = "id") Integer id) {
        return carService.getCarById(id);
    }

    @PostMapping("/add")
    public String saveCar(@Valid  @RequestBody AddCarRequest addCarRequest) throws Exception {
        return carService.saveCar(addCarRequest);
    }

    @PutMapping("/update")
    public String updateCar(@Valid @RequestBody UpdateCarRequest updateCarRequest) throws Exception {
        return this.carService.updateCar(updateCarRequest);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCar(@PathVariable int id) throws Exception {
        return this.carService.deleteCar(id);
    }
    @GetMapping("/findbycolorignorecase")
    public List<GetCarListResponse> findByColorIgnoreCase(@RequestParam String color) {

        return this.carService.findByColorIgnoreCase(color);
    }
    @GetMapping("/findbyyearandcolororderdesc")
    public List<GetCarListResponse> findByYearAndColorOrderByRentalFeeDesc(@RequestParam  Integer year, String color) {

        return this.carService.findByYearAndColorOrderByRentalFeeDesc(year, color);
    }


    @GetMapping("/searchbyyearandcolororrentalfee")
    public List<GetCarListResponse> searchByYearAndColorOrRentalFee(@RequestParam  String color,Integer year, Double rentalFee) {


        return this.carService.searchByYearAndColorOrRentalFee(color, year, rentalFee);
    }
    @GetMapping("/getbymodelrentalfeebetween")
    public List<GetCarListResponse> getByModelRentalFeeBetween(@RequestParam double minRentalFee, double maxRentalFee) {

        return this.carService.getByModelRentalFeeBetween(minRentalFee, maxRentalFee);

    }
}
