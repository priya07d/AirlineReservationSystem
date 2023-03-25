package com.ars.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ars.dto.PassengerDTO;
import com.ars.entity.Passenger;
import com.ars.repository.PassengerRepository;
import com.ars.service.PassengerService;

@Service
public class PassengerServiceImpl implements PassengerService{
	
	@Autowired
	PassengerRepository passengerRepository;

    //This method is used to make a reservation for a new passenger.
	@Override
	public Passenger reservation(PassengerDTO passengerDTO) {
		Passenger passenger = Passenger.builder().passengerName(passengerDTO.getPassengerName()).mobileNo(passengerDTO.getMobileNo()).build();
		return passengerRepository.save(passenger);
	}
	
	// This method is used to get the details of a passenger by their passenger ID.
	@Override
	public Passenger getById(int passengerId) {
		return passengerRepository.findById(passengerId).get();
	}

	//This method is used to cancel the reservation of a passenger by their passenger ID.
	@Override
	public String passengerDelete(int passengerId) {
		passengerRepository.deleteById(passengerId);
		return "Passenger with this: " + passengerId + "has been cancelled!!!";
	}
		
}
