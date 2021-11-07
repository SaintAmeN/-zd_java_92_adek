package com.sda.j92.academy.controller;

import com.sda.j92.academy.model.Compound;
import com.sda.j92.academy.service.CompoundService;
import com.sda.j92.academy.service.ElementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/tours")
@RequiredArgsConstructor
public class CompoundController {
    private final CompoundService compoundService;
    private final ElementService elementService;

    @CrossOrigin()
    @GetMapping("")
    public List<Compound> get(){
        return compoundService.findAll();
    }

    @CrossOrigin()
    @PostMapping("")
    public void add(@RequestBody Compound compound){
        compoundService.add(compound);
    }

    @CrossOrigin()
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        compoundService.delete(id);
    }

    @CrossOrigin()
    @GetMapping("/{id}")
    public Compound getById(@PathVariable Long id){
        return compoundService.getById(id);
    }

    @PostMapping("/attendee/{elementId}/{compoundId}")
    public Compound addAttendeeToTraining(@PathVariable  Long elementId, @PathVariable Long compoundId){
        return elementService.addElementToCompound(elementId, compoundId);
    }

    @DeleteMapping("/attendee/{tripId}/{attendeeId}")
    public Compound removeAttendeeToTraining(@PathVariable  Long elementId, @PathVariable Long compoundId){
        return elementService.removeElementFromCompound(elementId, compoundId);
    }
}
