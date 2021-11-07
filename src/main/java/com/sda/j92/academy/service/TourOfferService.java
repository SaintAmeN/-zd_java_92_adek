package com.sda.j92.academy.service;

import com.sda.j92.academy.model.TourAttendee;
import com.sda.j92.academy.model.TourOffer;
import com.sda.j92.academy.model.TourOfferDto;
import com.sda.j92.academy.repository.AttendeeRepository;
import com.sda.j92.academy.repository.TourOfferRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TourOfferService {
    private final TourOfferRepository tourOfferRepository;
    private final AttendeeRepository attendeeRepository;

    public List<TourOffer> findAll() {
        List<TourOffer> trainings = tourOfferRepository.findAll();
        log.info("GetAll : " + trainings);
        return trainings;
    }

    public void add(TourOffer training) {
        log.info("Add : " + training);
        tourOfferRepository.save(training);
    }

    public TourOfferDto getById(Long id) {
        Optional<TourOffer> academyTrainingOptional = tourOfferRepository.findById(id);
        if (academyTrainingOptional.isPresent()) {
            TourOffer offer = academyTrainingOptional.get();

            TourOfferDto dto = TourOfferDto.builder()
                    .id(offer.getId())
                    .nameTourOffer(offer.getNameTourOffer())
                    .guide(offer.getGuide())
                    .price(offer.getPrice())
                    .length(offer.getLength())
                    .country(offer.getCountry())
                    .timeStart(offer.getTimeStart())
                    .attendees(offer.getAttendees())
                    .build();

            return dto;
        }
        throw new EntityNotFoundException("Not found: " + id);
    }

    public void delete(Long id) {
        log.info("Get : " + id);
        tourOfferRepository.deleteById(id);
    }

    public TourOfferDto addAttendeeToTripOffer(Long trainingId, Long attendeeId) {
        Optional<TourOffer> trainingOptional = tourOfferRepository.findById(trainingId);
        Optional<TourAttendee> attendeeOptional = attendeeRepository.findById(attendeeId);

        if (trainingOptional.isPresent() && attendeeOptional.isPresent()){
            TourOffer offer = trainingOptional.get();
            TourAttendee attendee = attendeeOptional.get();

            offer.getAttendees().add(attendee);
            offer = tourOfferRepository.save(offer);

            TourOfferDto dto = TourOfferDto.builder()
                    .id(offer.getId())
                    .nameTourOffer(offer.getNameTourOffer())
                    .guide(offer.getGuide())
                    .price(offer.getPrice())
                    .length(offer.getLength())
                    .country(offer.getCountry())
                    .timeStart(offer.getTimeStart())
                    .attendees(offer.getAttendees())
                    .build();
            return dto;
        }
        return null;
    }

    public TourOfferDto removeAttendeeFromTripOffer(Long trainingId, Long attendeeId) {
        Optional<TourOffer> trainingOptional = tourOfferRepository.findById(trainingId);
        Optional<TourAttendee> attendeeOptional = attendeeRepository.findById(attendeeId);

        if (trainingOptional.isPresent() && attendeeOptional.isPresent()){
            TourOffer offer = trainingOptional.get();
            TourAttendee attendee = attendeeOptional.get();

            offer.getAttendees().remove(attendee);
            offer = tourOfferRepository.save(offer);

            TourOfferDto dto = TourOfferDto.builder()
                    .id(offer.getId())
                    .nameTourOffer(offer.getNameTourOffer())
                    .guide(offer.getGuide())
                    .price(offer.getPrice())
                    .length(offer.getLength())
                    .country(offer.getCountry())
                    .timeStart(offer.getTimeStart())
                    .attendees(offer.getAttendees())
                    .build();
            return dto;
        }
        return null;
    }
}
