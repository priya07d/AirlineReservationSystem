package com.ars.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ars.dto.AdminDTO;
import com.ars.entity.Admin;
import com.ars.entity.Passenger;

//this interface responsible for admin service
@Component
public interface AdminService {

	List<Admin> searchAll();
	Admin insert(AdminDTO adminDTO);
	Admin adminUpdate(Admin admin, int flightId);
	String adminDelete(int flightId);
	List<Passenger> getAll();
}
