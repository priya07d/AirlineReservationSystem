package com.ars.service;

import org.springframework.stereotype.Component;

import com.ars.dto.PassengerDTO;
import com.ars.entity.Passenger;

//this interface responsible for passenger service
@Component
public interface PassengerService {
	
	Passenger reservation(PassengerDTO passengerDTO);
	Passenger getById(int passengerId);
	String passengerDelete(int passengerId);
}
