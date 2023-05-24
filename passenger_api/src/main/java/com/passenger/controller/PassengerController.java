package com.passenger.controller;

import java.util.List;

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

import com.passenger.models.PassengerDetails;
import com.passenger.services.PassengerImplementation;
import com.passenger.success.SuccessResponse;

@RestController
@RequestMapping("api/v1")
public class PassengerController {
	
	PassengerImplementation passengerImplementation;
	
	@Autowired
	public PassengerController(PassengerImplementation implementation) {
		this.passengerImplementation=implementation;
	}
	
	@PostMapping("/passenger")
	public ResponseEntity<Object> save(@RequestBody PassengerDetails passengerDetails) {
		passengerImplementation.save(passengerDetails);
		return SuccessResponse.responseHandler("Passenger Saved Successfully", HttpStatus.CREATED);
	}
	
	@PostMapping("/passengers")
	public ResponseEntity<Object> saveAll(@RequestBody List<PassengerDetails> passengerDetails) {
		passengerImplementation.saveAll(passengerDetails);
		return SuccessResponse.responseHandler("Passengers List Saved Successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/passengers")
	public List<PassengerDetails> getAllPassengerDetails() {
		
		return passengerImplementation.allPassengerDetails();
		
	}
	
	@GetMapping("/passengers/{passengerId}")
	public PassengerDetails getPassengerDetailsById(@PathVariable(name = "passengerId") long passengerId) {
		return passengerImplementation.PassengerDetailsById(passengerId);
	}
	
	@DeleteMapping("/passengers")
	public ResponseEntity<Object> deleteAllPassengers() {
		passengerImplementation.deleteAllPassengerDetails();
		return SuccessResponse.responseHandler("Passengers list deleted Successfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/passengers/{passengerId}")
	public ResponseEntity<Object> deletePassengersById(@PathVariable(name = "passengerId") long passengerId) {
		passengerImplementation.deletePassengerDetailsById(passengerId);
		return SuccessResponse.responseHandler("Passenger  deleted Successfully", HttpStatus.OK);
	}
	
	@PutMapping("passengers")
	public ResponseEntity<Object> updatePassengerDetails(@RequestBody PassengerDetails passengerDetails) {
		passengerImplementation.updatePassengerDetails(passengerDetails);
		return SuccessResponse.responseHandler("Passenger Upadted Successfully", HttpStatus.OK);
	}
}
