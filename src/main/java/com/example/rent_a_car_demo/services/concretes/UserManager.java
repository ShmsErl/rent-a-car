package com.example.rent_a_car_demo.services.concretes;

import com.example.rent_a_car_demo.dtos.requests.AddUserRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateUserRequest;
import com.example.rent_a_car_demo.dtos.responses.GetUserListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetUserResponse;
import com.example.rent_a_car_demo.mapper.ModelMapperService;
import com.example.rent_a_car_demo.models.User;
import com.example.rent_a_car_demo.repositories.UserRepository;
import com.example.rent_a_car_demo.services.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final ModelMapperService mapperService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public List<GetUserListResponse> getAllUsers() {
        List<User> brands = this.userRepository.findAll();
        List<GetUserListResponse> getUserListResponses = new ArrayList<>();
        for (User user : brands) {
            GetUserListResponse getUserListResponse = this.mapperService.forResponse().map(user, GetUserListResponse.class);

            getUserListResponses.add(getUserListResponse);

        }
        return getUserListResponses;
    }

    public GetUserResponse getUserById(int id) {

        User user = this.userRepository.findById(id).orElseThrow();


        GetUserResponse getUserResponse = this.mapperService.forResponse().map(user, GetUserResponse.class);


       /* User user= this.userRepository.getReferenceById(id);
        GetUserResponse getUserResponse = new GetUserResponse();

        getUserResponse.setFirstName(user.getFirstName());
        getUserResponse.setLastName(user.getLastName());
        getUserResponse.setUsername(user.getUsername());
        getUserResponse.setEmail(user.getEmail());
        getUserResponse.setPhone(user.getPhone());
        getUserResponse.setGender(user.getGender());
        getUserResponse.setBirthDate(user.getBirthDate());*/

        return getUserResponse;
    }

    public GetUserResponse getUserByUsername(String username) {


        User user = this.userRepository.findByUsername(username);
        GetUserResponse getUserResponse =
                this.mapperService
                        .forResponse()
                        .map(user, GetUserResponse.class);
        return getUserResponse;
    }

    public String updateUser(int id, UpdateUserRequest user) throws Exception {
        User getUser = this.userRepository.findById(id).orElseThrow(() -> new Exception("UserNotFound"));

        getUser = this.mapperService.forRequest().map(user, User.class);


        this.userRepository.save(getUser);

        return "Transaction successful";
    }

    public String saveUser(AddUserRequest user) {
        User createdUser = this.mapperService.forRequest().map(user, User.class);
        createdUser.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        this.userRepository.save(createdUser);

        return "Transaction successful";
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
