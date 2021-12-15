package com.shruti_liveasy.shruti_liveasy.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.shruti_liveasy.shruti_liveasy.entities.Load;
import com.shruti_liveasy.shruti_liveasy.services.LoadService;

@RestController
public class MyController{
	
	@Autowired
	private LoadService loadService;	
	public String home() {
		
		return "Welcome to Load";
	}
	
	//get loads
	@GetMapping("/loads")
	public List<Load> getLoads()
	{
		return this.loadService.getLoads();
	}
	
	//get course by id
	@GetMapping("/loads/{shipperId}")
	public Load getLoads(@PathVariable long shipperId)
	{
		return this.loadService.getLoads(shipperId);
	}
	
	//add load
	@PostMapping("/loads")
	public Load addLoad(@RequestBody Load load) 
	{
		return this.loadService.addLoad(load);
	}
	
	//update load
	@PutMapping("/loads")
	public Load updateLoad(@RequestBody Load load)
	{
		return this.loadService.updateLoad(load);
	}
	
	//delete the course
	
	@DeleteMapping("/loads/{shipperId}")
	public ResponseEntity<HttpStatus> deleteLoad(@PathVariable long shipperId)
	{
		try {
			this.loadService.deleteLoad(shipperId);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch( Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}