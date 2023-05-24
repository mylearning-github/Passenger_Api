package com.passenger.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passenger.exceptionhandler.PassengerNotFound;
import com.passenger.models.PassengerDetails;
import com.passenger.repositories.PassengerRepository;

@Service
public class PassengerImplementation implements PassengerService {

	private PassengerRepository passengerRepository;
	private ModelMapper mapper;
	
	//Constructor 
	@Autowired
	public PassengerImplementation(PassengerRepository passengerRepository, ModelMapper mapper) {
		this.passengerRepository=passengerRepository;
		this.mapper=mapper;
	}
	
	@Override
	public void save(PassengerDetails passengerDetails) {
		passengerRepository.save(passengerDetails);
	}

	@Override
	public void saveAll(List<PassengerDetails> passengerDetails) {
		passengerRepository.saveAll(passengerDetails);
	}

	@Override
	public List<PassengerDetails> allPassengerDetails() {
		List<PassengerDetails> passengersList = passengerRepository.findAll();
		if (passengersList.isEmpty()) {
			throw new PassengerNotFound("No Passengers List Found");
		}
		
		return passengerRepository.findAll();
	}

	@Override
	public PassengerDetails PassengerDetailsById(long passengerId) {
		PassengerDetails PassengerDetails = passengerRepository.findById(passengerId).orElse(null);
		if (PassengerDetails==null) {
			throw new PassengerNotFound("No passenger Found on this Id  "+passengerId);
		}
		return passengerRepository.findById(passengerId).get();
	}

	@Override
	public void deleteAllPassengerDetails() {
		passengerRepository.deleteAll();
		
	}

	@Override
	public void deletePassengerDetailsById(long passengerId) {
		
		if (passengerRepository.existsById(passengerId)) {
			passengerRepository.deleteById(passengerId);
		}else {
			throw new PassengerNotFound("No passenger Found on this for delete "+passengerId);
		}
		
		
	}

	@Override
	public PassengerDetails updatePassengerDetails(PassengerDetails passengerDetails) {
		PassengerDetails passenger = passengerRepository.findById(passengerDetails.getPassengerId()).orElse(null);
		if (passenger==null) {
			throw new PassengerNotFound("No Passenger found for update");
			
		}
		mapper.map(passengerDetails, passenger);
		return passengerRepository.save(passengerDetails);
		
	}
}
