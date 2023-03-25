package com.ars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ars.entity.Admin;

//admin repository interface
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
