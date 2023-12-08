package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.dtos.requests.AddUserRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateUserRequest;
import com.example.rent_a_car_demo.dtos.responses.GetUserListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetUserResponse;
import com.example.rent_a_car_demo.services.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {

    public final UserService userService;



    @GetMapping("/getall")
    public List<GetUserListResponse> getAllUsers() {
        return userService.getAllUsers();
    }

        @GetMapping("/{id}")
    public GetUserResponse getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }


    @GetMapping("/byUsername/{username}")
    public GetUserResponse getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }


    @PostMapping("/add")
    public String saveUser(@RequestBody AddUserRequest user) {


        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id ,@RequestBody UpdateUserRequest user) throws Exception {



        return   userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
    @GetMapping("/avg")
    public  Double findAverageAgeInAgeRange(int minAge, int maxAge){

        return this.userService.findAverageAgeInAgeRange(minAge,maxAge);

    }
}