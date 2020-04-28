package com.example.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/beer")
public class TestController {

	@GetMapping(produces = { "application/json" },path = "/health")
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> getHealth(@RequestParam(value = "id", required = false) int a) {
		
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("1", "uno");
//			return new ResponseEntity<String>("OK",headers, HttpStatus.CREATED);
			
			return ResponseEntity.ok().headers(headers).body("ok");
//			return "OK";
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor Not Found", e);
		}
		
		
		

	}
}
