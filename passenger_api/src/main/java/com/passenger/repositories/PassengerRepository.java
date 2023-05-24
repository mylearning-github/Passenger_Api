package com.passenger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.passenger.models.PassengerAddress;
import com.passenger.models.PassengerDetails;


@Repository
public interface PassengerRepository extends JpaRepository<PassengerDetails, Long> {

	

}
