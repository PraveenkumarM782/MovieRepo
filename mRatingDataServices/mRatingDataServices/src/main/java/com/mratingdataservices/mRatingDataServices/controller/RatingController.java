package com.mratingdataservices.mRatingDataServices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mratingdataservices.mRatingDataServices.entity.Rating;
import com.mratingdataservices.mRatingDataServices.entity.UserRating;

@RestController
public class RatingController {
	
	@GetMapping("/ratingdata/{userId}")
	public Rating getRating(@PathVariable String userId) {
		
		//return "id and rating";
		return new Rating("m1001",5);
	}
	
	@GetMapping("ratingdata/users/{userId}")
	public UserRating getUserRating(@PathVariable String userId) {
		
		List<Rating> ratingresult = Arrays.asList(new Rating("m1001",5),new Rating("m1002",4));

		// return "id and rating";
	   // return ratingresult;
		
		UserRating ur = new UserRating();
		ur.setUserRating(ratingresult);
		
		return ur;
		
		
		
		
	}

}
