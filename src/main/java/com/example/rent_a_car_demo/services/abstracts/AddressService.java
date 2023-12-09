package com.example.rent_a_car_demo.services.abstracts;

import com.example.rent_a_car_demo.dtos.requests.AddAddressRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateAddressRequest;
import com.example.rent_a_car_demo.dtos.responses.GetAddressListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetAddressResponse;
import com.example.rent_a_car_demo.models.Address;

import java.util.List;

public interface AddressService {
    List<GetAddressListResponse> getAllAddresses();

    GetAddressResponse getAddressById(int id);

    void saveAddress(AddAddressRequest address);

    void updateAddress(int id, UpdateAddressRequest address);

    void deleteAddress(int id);

    List<GetAddressListResponse> findByCountryOrCity(String country, String city);

    List<GetAddressListResponse> findByCountryLike(String country);

    List<GetAddressListResponse> addressByCityLike(String city);

    List<GetAddressListResponse> findByCountryIn(List<String> countryList);
}
