package com.movieinfo.movieInfoServices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.movieinfo.movieInfoServices.entity.Movie;

@RestController
public class MovieInfoController {

	@GetMapping("/movie/{movieId}")
	public Movie getMovieinfo(@PathVariable String movieId) {
	//	return "returning (movie_Name) (movie_description)";
		
		return new Movie("Bahubali","EPic ACTion");
	}
}
