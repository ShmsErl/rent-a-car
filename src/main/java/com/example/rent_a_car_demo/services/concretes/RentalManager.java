package com.example.rent_a_car_demo.services.concretes;

import com.example.rent_a_car_demo.dtos.requests.AddRentalRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateRentalRequest;
import com.example.rent_a_car_demo.dtos.responses.GetRentalListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetRentalResponse;
import com.example.rent_a_car_demo.models.Rental;
import com.example.rent_a_car_demo.repositories.RentalRepository;
import com.example.rent_a_car_demo.services.abstracts.RentalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
    public final RentalRepository rentalRepository;


    @Override
    public List<GetRentalListResponse> getAllByRentals() {
        List<Rental> rentals = this.rentalRepository.findAll();
        List<GetRentalListResponse> getRentalListResponses = new ArrayList<>();

        for (Rental rental : rentals) {
            GetRentalListResponse response = new GetRentalListResponse();
            response.setRentalStartDate(rental.getRentalStartDate());
            response.setRentalEndDate(rental.getRentalEndDate());
            response.setCarName(rental.getCar().getLicencePlate());
            response.setUserName(rental.getUser().getFirstName());
            response.setEmployeeName(rental.getEmployee().getFirstName());
            response.setTotalCost(rental.getTotalCost());

            getRentalListResponses.add(response);


        }
        return getRentalListResponses;
    }

    @Override
    public GetRentalResponse getRentalById(int id) {

        Rental rental = this.rentalRepository.findById(id).orElseThrow();
        GetRentalResponse response = new GetRentalResponse();
        response.setRentalStartDate(rental.getRentalStartDate());
        response.setRentalEndDate(rental.getRentalEndDate());
        response.setCarName(rental.getCar().getLicencePlate());
        response.setUserName(rental.getUser().getFirstName());
        response.setEmployeeName(rental.getEmployee().getFirstName());
        response.setTotalCost(rental.getTotalCost());

        return response;
    }

    @Override
    public String saveRental(AddRentalRequest addRentalRequest) {

        Rental response = new Rental();

        response.setRentalStartDate(addRentalRequest.getRentalStartDate());
        response.setRentalEndDate(addRentalRequest.getRentalEndDate());
        response.setCar(addRentalRequest.getCar());
        response.setUser(addRentalRequest.getUser());
        response.setEmployee(addRentalRequest.getEmployee());
        response.setTotalCost(addRentalRequest.getTotalCost());
        this.rentalRepository.save(response);

        return "Transaction Successfull";
    }

    @Override
    public String updateRental(UpdateRentalRequest updateRentalRequest) {

        Rental response = this.rentalRepository.findById(updateRentalRequest.getId()).orElseThrow();

        response.setRentalStartDate(updateRentalRequest.getRentalStartDate());
        response.setRentalEndDate(updateRentalRequest.getRentalEndDate());
        response.setCar(updateRentalRequest.getCar());
        response.setUser(updateRentalRequest.getUser());
        response.setEmployee(updateRentalRequest.getEmployee());
        response.setTotalCost(updateRentalRequest.getTotalCost());
        this.rentalRepository.save(response);
        return "Transaction Successfull";
    }

    @Override
    public void deleteRental(int id) {

        this.rentalRepository.deleteById(id);

    }
}
