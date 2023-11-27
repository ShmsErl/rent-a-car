package com.example.rent_a_car_demo.services.abstracts;

import com.example.rent_a_car_demo.dtos.requests.AddAddressRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateAddressRequest;
import com.example.rent_a_car_demo.dtos.responses.GetAddressListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetAddressResponse;

import java.util.List;

public interface AddressService {
    List<GetAddressListResponse> getAllAddresses();
    GetAddressResponse getAddressById(int id);
    void saveAddress(AddAddressRequest address);
    void updateAddress(int id, UpdateAddressRequest address);
    void deleteAddress(int id);
}
