package com.sda.j92.academy.service;

import com.sda.j92.academy.model.ReservationInfo;
import com.sda.j92.academy.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public List<ReservationInfo> findAll(){
        List<ReservationInfo> reservationInfos = reservationRepository.findAll();
        log.info("GetAll : " + reservationInfos);
        return reservationInfos;
    }

    public void add(ReservationInfo reservationInfo){
        log.info("Add : " + reservationInfo);
        reservationRepository.save(reservationInfo);
    }

    public void delete(Long id){
        log.info("Remove : " + id);
        reservationRepository.deleteById(id);
    }

    public ReservationInfo getById(Long id) {
        Optional<ReservationInfo> compoundTraining = reservationRepository.findById(id);
        if (compoundTraining.isPresent()) {

            return compoundTraining.get();
        }
        throw new EntityNotFoundException("Not found: " + id);
    }
}
