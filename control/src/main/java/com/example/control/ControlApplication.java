package com.example.control;

import com.example.control.dao.entities.Car;
import com.example.control.dao.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlApplication.class, args);
    }
@Bean
    CommandLineRunner stat(CarRepository carRepository){
        return args -> {
            List<Car> carList=List.of(
                    Car.builder().model("x").color("x1").matricul("x2").price(5.0F).build(),
                    Car.builder().model("y").color("y1").matricul("y2").price(6.0F).build(),
                    Car.builder().model("z").color("z1").matricul("z2").price(7.0F).build(),
                    Car.builder().model("xp").color("xp1").matricul("xp2").price(8F).build());
            for(Car car:carList){
                carRepository.save(car);
            }
        };
}
}
