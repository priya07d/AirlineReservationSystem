package com.ars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ars.entity.Passenger;

//passenger repository interface
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
}
