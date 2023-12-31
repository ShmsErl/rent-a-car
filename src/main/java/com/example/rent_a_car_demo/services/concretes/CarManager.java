package com.example.rent_a_car_demo.services.concretes;

import com.example.rent_a_car_demo.dtos.requests.AddCarRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateCarRequest;
import com.example.rent_a_car_demo.dtos.responses.*;
import com.example.rent_a_car_demo.models.Car;
import com.example.rent_a_car_demo.repositories.CarRepository;
import com.example.rent_a_car_demo.services.abstracts.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private final CarRepository carRepository;


    public List<GetCarListResponse> getAllCars() {
        List<Car> carList = carRepository.findAll();
        List<GetCarListResponse> getCarListResponses = new ArrayList<>();

        for (Car car : carList) {
            GetCarListResponse dto = new GetCarListResponse();
            dto.setColor(car.getColor());
            dto.setYear(car.getYear());
            dto.setRentalFee(car.getRentalFee());
            dto.setLicencePlate(car.getLicencePlate());
            getCarListResponses.add(dto);
        }
        return getCarListResponses;
    }

    public GetCarResponse getCarById(int id) {
        Car car = carRepository.findById(id).orElseThrow();

        GetCarResponse dto = new GetCarResponse();
        dto.setColor(car.getColor());
        dto.setYear(car.getYear());
        dto.setRentalFee(car.getRentalFee());
        dto.setLicencePlate(car.getLicencePlate());

        return dto;
    }

    public String saveCar(AddCarRequest addCarRequest) throws Exception {

        if(this.carRepository.existsByLicencePlate(addCarRequest.getLicencePlate())){

            throw new Exception("Aldready exists Licence Plate");
        }
        Car car = new Car();
        car.setColor(addCarRequest.getColor());
        car.setYear(addCarRequest.getYear());
        car.setRentalFee(addCarRequest.getRentalFee());
        car.setLicencePlate(addCarRequest.getLicencePlate());
        car.setCarType(addCarRequest.getCarType());
        car.setModel(addCarRequest.getModel());
        carRepository.save(car);

        return "Transaction Successful ";
    }

    public String updateCar(UpdateCarRequest updateCarRequest) throws Exception {
        Car upToCar = carRepository.findById(updateCarRequest.getId()).orElseThrow(() -> new Exception("Car not found!"));

        upToCar.setColor(updateCarRequest.getColor());
        upToCar.setYear(updateCarRequest.getYear());
        upToCar.setRentalFee(updateCarRequest.getRentalFee());
        upToCar.setLicencePlate(updateCarRequest.getLicencePlate());
        this.carRepository.save(upToCar);

        return "Transaction Successful!";
    }

    public String deleteCar(int id) throws Exception {
        this.carRepository.findById(id).orElseThrow(() -> new Exception("Car not found!"));

        this.carRepository.deleteById(id);
        return "Delete Successful!";
    }

    @Override
    public List<GetCarListResponse> findByColorIgnoreCase(String color) {
        List<Car> carList = this.carRepository.findByColorIgnoreCase(color);
        List<GetCarListResponse> getCarListResponses = new ArrayList<>();

        for (Car car : carList) {
            GetCarListResponse dto = new GetCarListResponse();
            dto.setColor(car.getColor());
            dto.setYear(car.getYear());
            dto.setRentalFee(car.getRentalFee());
            dto.setLicencePlate(car.getLicencePlate());
            dto.setCarType(new GetCarTypeResponse(car.getCarType().getName()));
            dto.setModel(new GetModelResponse(car.getModel().getName(),
                    car.getModel().getFuelType(),
                    car.getModel().getEnginePower(),
                    new GetBrandResponse(car.getModel().getBrand().getName())));
            getCarListResponses.add(dto);
        }
        return getCarListResponses;

    }

    @Override
    public List<GetCarListResponse> findByYearAndColorOrderByRentalFeeDesc(Integer year, String color) {
        List<Car> carList = this.carRepository.findByYearAndColorOrderByRentalFeeDesc(year,color);
        List<GetCarListResponse> getCarListResponses = new ArrayList<>();

        for (Car car : carList) {
            GetCarListResponse dto = new GetCarListResponse();
            dto.setColor(car.getColor());
            dto.setYear(car.getYear());
            dto.setRentalFee(car.getRentalFee());
            dto.setLicencePlate(car.getLicencePlate());
            dto.setCarType(new GetCarTypeResponse(car.getCarType().getName()));
            dto.setModel(new GetModelResponse(car.getModel().getName(),
                    car.getModel().getFuelType(),
                    car.getModel().getEnginePower(),
                    new GetBrandResponse(car.getModel().getBrand().getName())));

            getCarListResponses.add(dto);
        }
        return getCarListResponses;
    }

    @Override
    public List<GetCarListResponse> searchByYearAndColorOrRentalFee(String color, Integer year ,Double rentalFee) {
        return this.carRepository.searchByYearAndColorOrRentalFee(color,year,rentalFee);
    }

    @Override
    public List<GetCarListResponse> getByModelRentalFeeBetween(double minRentalFee, double maxRentalFee) {
        return this.carRepository.getByModelRentalFeeBetween(minRentalFee,maxRentalFee);
    }
}
