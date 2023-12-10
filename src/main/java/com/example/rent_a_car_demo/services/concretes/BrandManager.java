package com.example.rent_a_car_demo.services.concretes;

import com.example.rent_a_car_demo.dtos.requests.AddBrandRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateBrandRequest;
import com.example.rent_a_car_demo.dtos.responses.GetBrandListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetBrandResponse;
import com.example.rent_a_car_demo.dtos.responses.GetUserListResponse;
import com.example.rent_a_car_demo.models.Brand;
import com.example.rent_a_car_demo.repositories.BrandRepository;
import com.example.rent_a_car_demo.services.abstracts.BrandService;
import lombok.AllArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;


    public List<GetBrandListResponse> getBrandList() {
        List<Brand> brandList = brandRepository.findAll();
        List<GetBrandListResponse> getBrandListResponse = new ArrayList<>();

        for (Brand brand : brandList) {
            GetBrandListResponse response = new GetBrandListResponse();
            response.setName(brand.getName());
            getBrandListResponse.add(response);
        }
        return getBrandListResponse;
    }

    public GetBrandResponse getBrandById(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();

        GetBrandResponse dto = new GetBrandResponse();
        dto.setName(brand.getName());

        return dto;
    }

    public String createBrand(AddBrandRequest addBrandRequest) throws Exception {
        boolean result = this.brandRepository.existsByName(addBrandRequest.getName());
        if(result){
            throw new Exception("Already exists Brand Name");
        }

        Brand brand = new Brand();
        brand.setName(addBrandRequest.getName());
        brandRepository.save(brand);

        return "Transaction Successful ";
    }

    public String updateBrand(UpdateBrandRequest updateBrandRequest) throws Exception {
        Brand upToBrand = brandRepository.findById(updateBrandRequest.getId()).orElseThrow(() -> new Exception("Could not find Brand"));

        upToBrand.setName(updateBrandRequest.getName());
        this.brandRepository.save(upToBrand);
        return "Transaction Successful";

    }

    public String deleteByBrand(int id) throws Exception {

        this.brandRepository.findById(id).orElseThrow(() -> new Exception("Could not"));

        this.brandRepository.deleteById(id);
        return "Deletion successful";
    }

    @Override
    public List<GetBrandListResponse> findByNameStartingWith(String name) {
        List<Brand> brands = this.brandRepository.findByNameStartingWith(name);
        List<GetBrandListResponse> responses = new ArrayList<>();
        GetBrandListResponse response = new GetBrandListResponse();
        brands.forEach(brand -> {
            response.setName(brand.getName());

            responses.add(response);
        });
        return responses;
    }

    @Override
    public List<GetBrandListResponse> findByNameEndingWith(String name) {
        List<Brand> brands = this.brandRepository.findByNameEndingWith(name);
        List<GetBrandListResponse> responses = new ArrayList<>();
        GetBrandListResponse response = new GetBrandListResponse();
        brands.forEach(brand -> {
            response.setName(brand.getName());

            responses.add(response);
        });
        return responses;
    }

    @Override
    public boolean existsByName(String name) {
        return this.existsByName(name) ;
    }

    @Override
    public List<GetBrandListResponse> findDistinctByName(String name) {
        return this.brandRepository.findDistinctByName(name);
    }

    @Override
    public List<GetBrandListResponse> findByNameLengthGreaterThan(int length) {
        return this.brandRepository.findByNameLengthGreaterThan(length);
    }
    @Override
    public void updateNameByIdAndName(String name, int id){

        this.brandRepository.updateNameByIdAndName(name,id);


    }
}
