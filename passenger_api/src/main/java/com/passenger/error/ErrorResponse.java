package com.passenger.error;


import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"dateTime","message","path","errors"})
public class ErrorResponse {

	private LocalDateTime dateTime;
	private String message;
	private String path;
	private List errors;
	
	
	
	
	
	
	
}
