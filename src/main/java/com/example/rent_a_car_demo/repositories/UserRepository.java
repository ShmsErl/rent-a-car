package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.dtos.responses.GetUserResponse;
import com.example.rent_a_car_demo.models.User;
import com.sun.tools.javac.Main;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByUsername(String username);

    User findByUsername(String username);

    @Query("SELECT AVG(u.id) FROM User u WHERE u.id BETWEEN :minAge AND :maxAge")
    Double findAverageAgeInAgeRange(@Param("minAge") int minAge, @Param("maxAge") int maxAge);


    @Query("SELECT new com.example.rent_a_car_demo.dtos.responses.GetUserResponse(u.firstName, u.lastName, u.username, u.email, u.phone, u.gender, u.birthDate)" +
            "FROM User u WHERE u.birthDate > :birthDate")
    List<GetUserResponse> findByBirthDateAfter(Date birthDate);

    @Query("SELECT new  com.example.rent_a_car_demo.dtos.responses.GetUserResponse(u.firstName, u.lastName, u.username, u.email, u.phone, u.gender, u.birthDate)" +
            "FROM User u WHERE u.email = :email AND u.password = :password")
    List<GetUserResponse> findByEmailAndPassword(String email, String password);

    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.username = :username")
    void deleteByUsername(String username);


}




