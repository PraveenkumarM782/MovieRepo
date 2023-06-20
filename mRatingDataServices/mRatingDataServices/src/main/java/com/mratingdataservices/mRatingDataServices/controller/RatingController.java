package com.mratingdataservices.mRatingDataServices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mratingdataservices.mRatingDataServices.entity.Rating;

@RestController
public class RatingController {
	
	@GetMapping("/rating/{userId}")
	public Rating getRating(@PathVariable String userId) {
		
		//return "id and rating";
		return new Rating("m1001",5);
	}

}
