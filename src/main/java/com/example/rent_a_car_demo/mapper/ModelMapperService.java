package com.example.rent_a_car_demo.mapper;
import org.modelmapper.ModelMapper;
public interface ModelMapperService  {

  ModelMapper forRequest();

  ModelMapper forResponse();
}
