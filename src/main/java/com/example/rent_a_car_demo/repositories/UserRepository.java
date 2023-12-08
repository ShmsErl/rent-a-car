package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.models.User;
import com.sun.tools.javac.Main;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    @Query("SELECT AVG(u.id) FROM User u WHERE u.id BETWEEN :minAge AND :maxAge")
    Double findAverageAgeInAgeRange(@Param("minAge") int minAge, @Param("maxAge") int maxAge);

}




