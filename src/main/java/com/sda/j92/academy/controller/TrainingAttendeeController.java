package com.sda.j92.academy.controller;

import com.sda.j92.academy.model.TourAttendee;
import com.sda.j92.academy.service.AttendeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/attendees")
@RequiredArgsConstructor
public class TrainingAttendeeController {
    private final AttendeeService attendeeService;

    @CrossOrigin()
    @GetMapping("")
    public List<TourAttendee> get(){
        return attendeeService.findAll();
    }

    @CrossOrigin()
    @PostMapping("")
    public void add(@RequestBody TourAttendee training){
        attendeeService.add(training);
    }

    @CrossOrigin()
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        attendeeService.delete(id);
    }



}
