package com.ars.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ars.dto.AdminDTO;
import com.ars.entity.Admin;
import com.ars.entity.Passenger;
import com.ars.repository.AdminRepository;
import com.ars.repository.PassengerRepository;
import com.ars.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	PassengerRepository passengerRepository;

	// Inserts a new Admin into the data source using an AdminDTO object.
	@Override
	public Admin insert(AdminDTO adminDTO) {
		Admin admin = Admin.builder().flightName(adminDTO.getFlightName()).flightDateTime(adminDTO.getFlightDateTime()).flightFrom(adminDTO.getFlightFrom()).flightTo(adminDTO.getFlightTo()).build();
		return adminRepository.save(admin);
	}
	
	//Retrieves a list of all Admin entities 
	@Override
	public List<Admin> searchAll() {
		return adminRepository.findAll();
	}
	
	// Updates an existing Admin entity 
	@Override
	public Admin adminUpdate(Admin admin, int flightId) {
		Admin  _admin = adminRepository.findById(flightId).get();
		_admin.setFlightId(admin.getFlightId());
		_admin.setFlightName(admin.getFlightName());
		_admin.setFlightDateTime(admin.getFlightDateTime());
		_admin.setFlightFrom(admin.getFlightFrom());
		_admin.setFlightTo(admin.getFlightTo());
		return adminRepository.save(_admin);
	}

	//Deletes an Admin entity by its flight ID.
	@Override
	public String adminDelete(int flightId) {
		adminRepository.deleteById(flightId);;
		return "Flight with this: " + flightId + "has been cancelled!!!";
	}
	
	//fetch all the data from passenger entity
	@Override
	public List<Passenger> getAll() {
		return passengerRepository.findAll();
	}
}
