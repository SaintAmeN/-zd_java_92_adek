package com.sda.j92.academy.service;

import com.sda.j92.academy.model.Compound;
import com.sda.j92.academy.model.Element;
import com.sda.j92.academy.repository.CompoundRepository;
import com.sda.j92.academy.repository.ElementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ElementService {
    private final ElementRepository elementRepository;
    private final CompoundRepository compoundRepository;

    public List<Element> findAll() {
        List<Element> elements = elementRepository.findAll();
        log.info("GetAll : " + elements);
        return elements;
    }

    public void add(Element element) {
        log.info("Add : " + element);
        elementRepository.save(element);
    }

    public Element getById(Long id) {
        Optional<Element> elementTrainingOptional = elementRepository.findById(id);
        if (elementTrainingOptional.isPresent()) {

            return elementTrainingOptional.get();
        }
        throw new EntityNotFoundException("Not found: " + id);
    }

    public void delete(Long id) {
        log.info("Get : " + id);
        elementRepository.deleteById(id);
    }

    public Compound addElementToCompound(Long elementId, Long compoundId) {
        Optional<Element> elementOptional = elementRepository.findById(elementId);
        Optional<Compound> compoundOptional = compoundRepository.findById(compoundId);

        if (elementOptional.isPresent() && compoundOptional.isPresent()){
            Element elememnt = elementOptional.get();
            Compound compound = compoundOptional.get();

            compound.getElements().add(elememnt);
            compound = compoundRepository.save(compound);

            return compound;
        }
        return null;
    }

    public Compound removeElementFromCompound(Long elementId, Long compoundId) {
        Optional<Element> elementOptional = elementRepository.findById(elementId);
        Optional<Compound> compoundOptional = compoundRepository.findById(compoundId);

        if (elementOptional.isPresent() && compoundOptional.isPresent()){
            Element elememnt = elementOptional.get();
            Compound compound = compoundOptional.get();

            compound.getElements().remove(elememnt);
            compound = compoundRepository.save(compound);

            return compound;
        }
        return null;
    }
}
