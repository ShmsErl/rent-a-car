package com.example.rent_a_car_demo.services.concretes;

import com.example.rent_a_car_demo.dtos.requests.AddBrandRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateBrandRequest;
import com.example.rent_a_car_demo.dtos.responses.GetBrandListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetBrandResponse;
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

    public String createBrand(AddBrandRequest addBrandRequest) {
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
    public GetBrandResponse findByNameLike(String name) {
        return this.brandRepository.getBrandByName(name);
    }

    @Override
    public List<GetBrandResponse> findByNameIn(int name) {
        return this.brandRepository.getBrandByNameIn(name);
    }

    @Override
    public List<GetBrandResponse> getByNameIn(List<String> name) {
        List<Brand> brands = this.brandRepository.findByNameIn(name);
        List<GetBrandResponse> result = new ArrayList<>();
        for (Brand brand : brands ) {
            GetBrandResponse response = new GetBrandResponse();
            response.setName(brand.getName());


        }
        return result;
    }
}
