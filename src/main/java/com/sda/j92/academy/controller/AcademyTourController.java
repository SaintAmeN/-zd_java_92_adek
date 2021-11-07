package com.sda.j92.academy.controller;

import com.sda.j92.academy.model.TourOffer;
import com.sda.j92.academy.model.TourOfferDto;
import com.sda.j92.academy.service.TourOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/tours")
@RequiredArgsConstructor
public class AcademyTourController {
    private final TourOfferService tourOfferService;

    @CrossOrigin()
    @GetMapping("")
    public List<TourOffer> get(){
        return tourOfferService.findAll();
    }

    @CrossOrigin()
    @PostMapping("")
    public void add(@RequestBody TourOffer offer){
        tourOfferService.add(offer);
    }

    @CrossOrigin()
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        tourOfferService.delete(id);
    }

    @CrossOrigin()
    @GetMapping("/{id}")
    public TourOfferDto getById(@PathVariable Long id){
        return tourOfferService.getById(id);
    }

    @PostMapping("/attendee/{tripId}/{attendeeId}")
    public TourOfferDto addAttendeeToTraining(@PathVariable  Long tripId, @PathVariable Long attendeeId){
        return tourOfferService.addAttendeeToTripOffer(tripId, attendeeId);
    }

    @DeleteMapping("/attendee/{tripId}/{attendeeId}")
    public TourOfferDto removeAttendeeFromTraining(@PathVariable  Long tripId, @PathVariable Long attendeeId){
        return tourOfferService.removeAttendeeFromTripOffer(tripId, attendeeId);
    }
}
