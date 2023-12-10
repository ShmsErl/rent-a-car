package com.example.rent_a_car_demo.services.abstracts;

import com.example.rent_a_car_demo.dtos.requests.AddUserRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateUserRequest;
import com.example.rent_a_car_demo.dtos.responses.GetUserListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetUserResponse;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface UserService {
    List<GetUserListResponse> getAllUsers();

    GetUserResponse getUserById(int id);

    GetUserResponse getUserByUsername(String username);

    String updateUser(int id, UpdateUserRequest user) throws Exception;

    String saveUser(AddUserRequest user);

    void deleteUser(int id);

    Double findAverageAgeInAgeRange(int minAge, int maxAge);

    List<GetUserResponse> findByBirthDateAfter(Date birthDate);

    List<GetUserResponse> findByEmailAndPassword(String email, String password);


}
