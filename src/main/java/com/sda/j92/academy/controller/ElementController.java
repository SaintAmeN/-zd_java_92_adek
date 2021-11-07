package com.sda.j92.academy.controller;

import com.sda.j92.academy.model.Element;
import com.sda.j92.academy.service.CompoundService;
import com.sda.j92.academy.service.ElementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/attendees")
@RequiredArgsConstructor
public class ElementController {
    private final ElementService elementService;

    @CrossOrigin()
    @GetMapping("")
    public List<Element> get(){
        return elementService.findAll();
    }

    @CrossOrigin()
    @PostMapping("")
    public void add(@RequestBody Element element){
        elementService.add(element);
    }

    @CrossOrigin()
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        elementService.delete(id);
    }



}
