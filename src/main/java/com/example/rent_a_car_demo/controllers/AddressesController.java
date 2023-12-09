package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.dtos.requests.AddAddressRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateAddressRequest;
import com.example.rent_a_car_demo.dtos.responses.GetAddressListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetAddressResponse;
import com.example.rent_a_car_demo.services.abstracts.AddressService;
import com.example.rent_a_car_demo.services.concretes.AddressManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@AllArgsConstructor
public class AddressesController {

    private final AddressService addressService;



    @GetMapping("/getall")
    public List<GetAddressListResponse> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/get")
    public GetAddressResponse getAddressById(@RequestParam(value = "id") int id) {
        return addressService.getAddressById(id);
    }

    @PostMapping("/add")
    public void saveAddress(@RequestBody AddAddressRequest request) {
        addressService.saveAddress(request);
    }

    @PutMapping("/{id}")
    public void updateAddress(@PathVariable int id, @RequestBody UpdateAddressRequest address) {

        addressService.updateAddress(id, address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable int id) {
        addressService.deleteAddress(id);
    }
    @GetMapping("/findbycountryorcity")
    public List<GetAddressListResponse> findByCountryOrCity(@RequestParam String country, String city) {

        return this.addressService.findByCountryOrCity(country, city);
    }

    @GetMapping("/findbycountrylike")
    public List<GetAddressListResponse> findByCountryLike(@RequestParam String country) {

        return this.addressService.findByCountryLike(country) ;
    }
    @GetMapping("/addressbycitylike")
    public List<GetAddressListResponse> addressByCityLike(@RequestParam String city) {

        return this.addressService.addressByCityLike(city);
    }
    @GetMapping("/findbybountryin")
    public List<GetAddressListResponse> findByCountryIn(@RequestParam List<String> countryList) {

        return this.addressService.findByCountryIn(countryList);
    }
}