package com.ars.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ars.dto.PassengerDTO;
import com.ars.entity.Passenger;
import com.ars.service.PassengerService;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

	//inject the passenger service
	@Autowired
	PassengerService  passengerService;
	
	//insert a new passenger
	@PostMapping("/passenger/add")
	public ResponseEntity<Passenger> Add(@RequestBody @Valid PassengerDTO passengerDTO) {
		return new ResponseEntity<>(passengerService.reservation(passengerDTO), HttpStatus.CREATED);
	}

	//fetch the passenger by id
	@GetMapping("/passenger/{passengerId}")
	public Passenger getAPassenger(@PathVariable int passengerId) {
		return passengerService.getById(passengerId);
	}

    //delete passenge by id	
	@DeleteMapping("/passenger/{passengerId}")
	public String cancel(@PathVariable int passengerId) {
		return passengerService.passengerDelete(passengerId);
	}
}
