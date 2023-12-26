package com.example.control.web;

import com.example.control.dao.entities.Car;
import com.example.control.dao.repositories.CarRepository;
import com.example.control.service.dtos.CarDTO;
import com.example.control.service.mappers.CarMapper;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CarGraphQLController {
    private CarRepository carRepository;
    private CarMapper carMapper=new CarMapper();
    CarGraphQLController(CarRepository carRepository){
        this.carRepository=carRepository;
    }
    @QueryMapping
    public List<CarDTO> carList()
    {
        List<Car> carList=carRepository.findAll();
        return carList.stream().map(carMapper::fromCar).toList();

    }
    @QueryMapping
    public CarDTO carfindbyid(@Argument Long id)
    {
        Car car=carRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Non car %s",id)));
        return carMapper.fromCar(car);
    }
    @QueryMapping
    public List<CarDTO>  getCarByModel(@Argument String model)
    {
        List<Car> carList=carRepository.findByModel(model);
        return carList.stream().map(carMapper::fromCar).toList();

    }
    @QueryMapping
    public CarDTO  getCarByModelAndPrice(@Argument String model,Float price)
    {
        Car car= carRepository.findByModelAndPrice(model,price);
        return carMapper.fromCar(car);

    }
    @MutationMapping
    public Car saveCar(@Argument CarDTO carDTO){
        Car car=carMapper.fromCarDTO(carDTO);
        return carRepository.save(car);
    }

    @MutationMapping
    public void deleteCar(@Argument Long id)
    {

      carRepository.deleteById(id);

    }
}
