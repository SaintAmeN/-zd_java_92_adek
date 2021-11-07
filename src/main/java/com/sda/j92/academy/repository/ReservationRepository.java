package com.sda.j92.academy.repository;

import com.sda.j92.academy.model.ReservationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationInfo, Long> {
}
