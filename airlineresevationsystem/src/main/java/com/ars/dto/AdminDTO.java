package com.ars.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
//this class is responsible for validation
public class AdminDTO {
	
	@NotBlank(message = "Invalid Name: Empty Name")
	@NotNull(message = "Invalid Name: name is NULL")
	@Size(min = 3, max = 25, message = "Invalid Name: Must be of 3-25 characters")
	private String flightName;
	
	@NotBlank(message = "Invalid Date and time ")
	private LocalDateTime flightDateTime;
	
	@NotBlank(message = "Not Blank")
	private String flightFrom;
	
	@NotBlank(message = "Not Blank")
	private String flightTo;
}
