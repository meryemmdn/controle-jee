package com.example.control.service.mappers;

import com.example.control.dao.entities.Car;
import com.example.control.service.dtos.CarDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    private final ModelMapper modelMapper=new ModelMapper();
    public CarDTO fromCar(Car car){
        return this.modelMapper.map(car,CarDTO.class);
    }
    public Car fromCarDTO(CarDTO carDTO){
        return this.modelMapper.map(carDTO,Car.class);
    }

}
