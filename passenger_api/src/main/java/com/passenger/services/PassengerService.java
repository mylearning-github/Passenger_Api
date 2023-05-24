package com.passenger.services;

import java.util.List;

import com.passenger.models.PassengerDetails;

public interface PassengerService {
	
	public void save(PassengerDetails passengerDetails);
	public void saveAll(List<PassengerDetails> passengerDetails);
	public List<PassengerDetails> allPassengerDetails();
	public PassengerDetails PassengerDetailsById(long passengerId);
	public void deleteAllPassengerDetails();
	public void deletePassengerDetailsById(long passengerId);
	public PassengerDetails updatePassengerDetails(PassengerDetails passengerDetails );
	

}
