package com.passenger.success;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SuccessResponse {

	public static  ResponseEntity<Object> responseHandler(String message, HttpStatus statusCode) {
		Map<String, Object> map = new HashMap<>();
		map.put("Timestamp", new Date());
		map.put("message", message);
		map.put("status", statusCode.value());
		return new ResponseEntity<Object>(map,statusCode);
	}
}
