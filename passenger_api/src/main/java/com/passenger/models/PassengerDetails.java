package com.passenger.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PassengerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long passengerId;
	
	@NotNull(message = "Surname required")
	private String passengerSurName;
	
	@NotNull(message = "Passenger name required")
	private String passengerName;
	
	@NotNull(message = "Passenger age required")
	private int passengerAge;
	
	@NotNull(message = "Passenger Gender required")
	private String passengerGender;
	
	@NotNull(message = "Passenger mobile required")
	private String mobileNumber;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = PassengerAddress.class )
	@JoinColumn(name = "address_Id", referencedColumnName = "addressId" , nullable = true)
	@Valid
	private PassengerAddress passengerAddress;
	

}
