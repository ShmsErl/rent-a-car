package com.example.rent_a_car_demo.services.abstracts;

import com.example.rent_a_car_demo.dtos.requests.AddRentalRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateRentalRequest;
import com.example.rent_a_car_demo.dtos.responses.GetRentalListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetRentalResponse;
import com.example.rent_a_car_demo.models.Rental;
import com.example.rent_a_car_demo.repositories.RentalRepository;

import java.util.List;

public interface RentalService {


    List<GetRentalListResponse> getAllByRentals();

    GetRentalResponse getRentalById(int id);

    String saveRental(AddRentalRequest addRentalRequest);

    String updateRental(UpdateRentalRequest updateRentalRequest);

    void deleteRental(int id);
}
