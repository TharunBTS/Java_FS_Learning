package com.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.AvailabilityDates;


@Repository
public interface IAvailabilityDatesRepository extends JpaRepository<AvailabilityDates, Integer>{

}
