package com.sda.j92.academy.service;

import com.sda.j92.academy.model.ReservationInfo;
import com.sda.j92.academy.model.Car;
import com.sda.j92.academy.repository.ReservationRepository;
import com.sda.j92.academy.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final ReservationRepository reservationRepository;

    public List<Car> findAll() {
        List<Car> cars = carRepository.findAll();
        log.info("GetAll : " + cars);
        return cars;
    }

    public void add(Car car) {
        log.info("Add : " + car);
        carRepository.save(car);
    }

    public Car getById(Long id) {
        Optional<Car> elementTrainingOptional = carRepository.findById(id);
        if (elementTrainingOptional.isPresent()) {

            return elementTrainingOptional.get();
        }
        throw new EntityNotFoundException("Not found: " + id);
    }

    public void delete(Long id) {
        log.info("Get : " + id);
        carRepository.deleteById(id);
    }

    public Car addReservationToCar(Long carId, Long reservationId) {
        Optional<Car> elementOptional = carRepository.findById(carId);
        Optional<ReservationInfo> compoundOptional = reservationRepository.findById(reservationId);

        if (elementOptional.isPresent() && compoundOptional.isPresent()){
            Car car = elementOptional.get();
            ReservationInfo reservationInfo = compoundOptional.get();

            car.getReservations().add(reservationInfo);
            car = carRepository.save(car);

            return car;
        }
        return null;
    }

    public Car removeReservationFromCar(Long carId, Long reservationId) {
        Optional<Car> carOptional = carRepository.findById(carId);
        Optional<ReservationInfo> reservationOptional = reservationRepository.findById(reservationId);

        if (carOptional.isPresent() && reservationOptional.isPresent()){
            Car car = carOptional.get();
            ReservationInfo reservationInfo = reservationOptional.get();

            car.getReservations().remove(reservationInfo);
            car = carRepository.save(car);

            return car;
        }
        return null;
    }
}
