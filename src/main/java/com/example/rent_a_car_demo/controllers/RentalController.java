package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.dtos.requests.AddRentalRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateRentalRequest;
import com.example.rent_a_car_demo.dtos.responses.GetRentalListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetRentalResponse;
import com.example.rent_a_car_demo.models.Rental;
import com.example.rent_a_car_demo.services.abstracts.RentalService;
import com.example.rent_a_car_demo.services.concretes.RentalManager;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@AllArgsConstructor
public class RentalController {

    private final RentalService rentalService;

    @GetMapping("/getall")
    public List<GetRentalListResponse> getAllRentals() {

       return this.rentalService.getAllByRentals();
    }
    @GetMapping("/get")
    public GetRentalResponse getRentalById(@RequestParam(value = "id") Integer id){
        return rentalService.getRentalById(id);
    }
    @PostMapping("/add")
    public String saveRental(@Valid  @RequestBody AddRentalRequest rental){return  rentalService.saveRental(rental);}
    @PutMapping("/{id}")
    public String updateRental(@Valid @PathVariable int id,@RequestBody UpdateRentalRequest rental){

      return   rentalService.updateRental(rental);
    }
    @DeleteMapping("/{id}")
    public void deleteRental(@PathVariable int id){rentalService.deleteRental(id);}
}
