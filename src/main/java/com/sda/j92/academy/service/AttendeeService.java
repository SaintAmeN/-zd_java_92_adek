package com.sda.j92.academy.service;

import com.sda.j92.academy.model.TourAttendee;
import com.sda.j92.academy.repository.AttendeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AttendeeService {
    private final AttendeeRepository attendeeRepository;

    public List<TourAttendee> findAll(){
        List<TourAttendee> attendees = attendeeRepository.findAll();
        log.info("GetAll : " + attendees);
        return attendees;
    }

    public void add(TourAttendee training){
        log.info("Add : " + training);
        attendeeRepository.save(training);
    }

    public void delete(Long id){
        log.info("Remove : " + id);
        attendeeRepository.deleteById(id);
    }
}
