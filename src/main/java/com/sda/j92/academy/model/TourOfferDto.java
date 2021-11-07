package com.sda.j92.academy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TourOfferDto {
    private Long id;

    private String nameTourOffer;
    private String country;
    private LocalDate timeStart;
    private int length;
    private double price;
    private String guide;

    private Set<TourAttendee> attendees;
}
