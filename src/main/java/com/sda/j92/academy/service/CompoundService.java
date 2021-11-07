package com.sda.j92.academy.service;

import com.sda.j92.academy.model.Compound;
import com.sda.j92.academy.model.Element;
import com.sda.j92.academy.repository.CompoundRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompoundService {
    private final CompoundRepository compoundRepository;

    public List<Compound> findAll(){
        List<Compound> compounds = compoundRepository.findAll();
        log.info("GetAll : " + compounds);
        return compounds;
    }

    public void add(Compound compound){
        log.info("Add : " + compound);
        compoundRepository.save(compound);
    }

    public void delete(Long id){
        log.info("Remove : " + id);
        compoundRepository.deleteById(id);
    }

    public Compound getById(Long id) {
        Optional<Compound> compoundTraining = compoundRepository.findById(id);
        if (compoundTraining.isPresent()) {

            return compoundTraining.get();
        }
        throw new EntityNotFoundException("Not found: " + id);
    }
}
