package com.sda.j92.academy.controller;

import com.sda.j92.academy.model.Car;
import com.sda.j92.academy.model.ReservationInfo;
import com.sda.j92.academy.service.ReservationService;
import com.sda.j92.academy.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;
    private final CarService carService;

    @CrossOrigin()
    @GetMapping("")
    public List<ReservationInfo> get(){
        return reservationService.findAll();
    }

    @CrossOrigin()
    @PostMapping("")
    public void add(@RequestBody ReservationInfo reservationInfo){
        reservationService.add(reservationInfo);
    }

    @CrossOrigin()
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        reservationService.delete(id);
    }

    @CrossOrigin()
    @GetMapping("/{id}")
    public ReservationInfo getById(@PathVariable Long id){
        return reservationService.getById(id);
    }

    @PostMapping("/attendee/{elementId}/{compoundId}")
    public Car addAttendeeToTraining(@PathVariable  Long elementId, @PathVariable Long compoundId){
        return carService.addReservationToCar(elementId, compoundId);
    }

    @DeleteMapping("/attendee/{tripId}/{attendeeId}")
    public Car removeAttendeeToTraining(@PathVariable  Long carId, @PathVariable Long reservationId){
        return carService.removeReservationFromCar(carId, reservationId);
    }
}
