package com.ars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ars.date.DateFormat;
import com.ars.entity.Admin;
import com.ars.entity.Passenger;
import com.ars.repository.AdminRepository;
import com.ars.repository.PassengerRepository;

@SpringBootApplication
public class AirlineresevationsystemApplication implements CommandLineRunner{

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AirlineresevationsystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//create admin object 
		Admin a1 = Admin.builder().flightName("Indigo").flightDateTime(DateFormat.toLocalDateTime("2023-03-24 20:00:00")).flightFrom("Delhi Airport").flightTo("Mumbai Airport").build();
		
		//save the admin object 
		adminRepository.save(a1);
		
		//create passenger object
		Passenger p1 = Passenger.builder().passengerName("Amitava Chattopadhayay").mobileNo("1234567890").flight_id(a1).build();
		Passenger p2 = Passenger.builder().passengerName("Monalisa Chakraborty").mobileNo("1234567898").flight_id(a1).build();
		Passenger p3 = Passenger.builder().passengerName("Abhishek Raj").mobileNo("2345678901").flight_id(a1).build();
		Passenger p4 = Passenger.builder().passengerName("Akansha Kunjir").mobileNo("3456789012").flight_id(a1).build();
		Passenger p5 = Passenger.builder().passengerName("Priya").mobileNo("4567890123").flight_id(a1).build();
		
		//save passenger object
		passengerRepository.save(p1);
		passengerRepository.save(p2);
		passengerRepository.save(p3);
		passengerRepository.save(p4);
		passengerRepository.save(p5);
		
		//print the message 
		System.out.println("===========All Data Saved========");
		
	}

}
