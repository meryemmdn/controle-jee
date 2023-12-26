package com.example.control.dao.repositories;

import com.example.control.dao.entities.Car;
import com.example.control.service.dtos.CarDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Long> {
    List<Car> findByModel(String model);
    Car findByModelAndPrice(String model,Float price);
}
