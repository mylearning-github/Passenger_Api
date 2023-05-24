package com.passenger.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PassengerAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long addressId;
	private int flatNo;
	private String streetName;
	private String landMark;
	private String pincode;
	private String city;
	private String state;
	private String country;

}
