package com.example.rent_a_car_demo.services.concretes;

import com.example.rent_a_car_demo.models.Rental;
import com.example.rent_a_car_demo.repositories.RentalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentalManager {
    public final RentalRepository rentalRepository;

    public RentalManager(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public List<Rental> getAllByRentals(){return rentalRepository.findAll(); }
    public Rental getRentalById(Integer id){return rentalRepository.findById(id).orElseThrow();}
    public void saveRental(Rental rental){rentalRepository.save(rental);}
    public void deleteRental(Integer id){rentalRepository.deleteById(id);}
}
