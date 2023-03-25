package com.ars.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ars.dto.AdminDTO;
import com.ars.entity.Admin;
import com.ars.entity.Passenger;
import com.ars.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	//inject the admin service
	@Autowired
	private AdminService adminService;
	
	//insert a new admin
	@PostMapping("/admin/add")
	public ResponseEntity<Admin> Insert(@RequestBody @Valid AdminDTO adminDTO) {
		return new ResponseEntity<>(adminService.insert(adminDTO),HttpStatus.CREATED);
	}

	//update an existing admin
	@PutMapping("/admin/{flightId}")
	public Admin update(@PathVariable int flightId, @RequestBody Admin admin) {
		return adminService.adminUpdate(admin, flightId);
	}

	//delete an existing admin
	@DeleteMapping("/admin/{flightId}")
	public String delete(@PathVariable int flightId) {
		return adminService.adminDelete(flightId);
	}

	//fetch all admin records
	@GetMapping("/flights")
	public List<Admin> fetchAll() {
		return adminService.searchAll();

	}
	
	//fetch all passengers records by admin
	@GetMapping("/passengers")
	public List<Passenger> findAll() {
		return adminService.getAll();
	}

}
