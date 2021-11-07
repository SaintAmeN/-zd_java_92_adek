package com.sda.j92.academy.controller;

import com.sda.j92.academy.model.Car;
import com.sda.j92.academy.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @CrossOrigin()
    @GetMapping("")
    public List<Car> get(){
        return carService.findAll();
    }

    @CrossOrigin()
    @PostMapping("")
    public void add(@RequestBody Car car){
        carService.add(car);
    }

    @CrossOrigin()
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        carService.delete(id);
    }



}
