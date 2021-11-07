package com.sda.j92.academy.repository;

import com.sda.j92.academy.model.TourOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourOfferRepository extends JpaRepository<TourOffer, Long> {
}
