package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.dtos.responses.GetUserResponse;
import com.example.rent_a_car_demo.models.Employee;
import com.example.rent_a_car_demo.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {




}
