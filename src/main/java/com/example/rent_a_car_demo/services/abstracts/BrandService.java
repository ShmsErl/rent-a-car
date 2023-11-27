package com.example.rent_a_car_demo.services.abstracts;

import com.example.rent_a_car_demo.dtos.requests.AddBrandRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateBrandRequest;
import com.example.rent_a_car_demo.dtos.responses.GetBrandListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetBrandResponse;

import java.util.List;

public interface BrandService {


    List<GetBrandListResponse> getBrandList();

    GetBrandResponse getBrandById(int id);

    String createBrand(AddBrandRequest addBrandRequest);

    String updateBrand(UpdateBrandRequest updateBrandRequest) throws Exception;

    String deleteByBrand(int id) throws Exception;

}
