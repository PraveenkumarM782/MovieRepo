package com.moviecatlog.movieCatalogServices.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.moviecatlog.movieCatalogServices.entity.Catalog;
import com.moviecatlog.movieCatalogServices.entity.Movie;
import com.moviecatlog.movieCatalogServices.entity.Rating;
import com.moviecatlog.movieCatalogServices.entity.UserRating;

@RestController
public class MovieCatalogueResourceController {
	
	@Autowired
	private RestTemplate rt;

	@GetMapping("/catalog/{Userid}")
	public List<Catalog> getCatalog(@PathVariable String Userid) {
		
		//return "Movie details .........................................";

		//return	Collections.singletonList(new Catalog("Bahubali","Epic and Action",5));  //here we are doing hardcoding means typing manually
		//above we are doing hardcoding i.e manually passing data , So to do dynamically we will do following code...and first comment above code


	//	List<Rating> ratingresult = Arrays.asList(new Rating("m1001",5),new Rating("m1002",4));

		// RestTemplate rt = new RestTemplate();
		
	   UserRating userrating = rt.getForObject("http://localhost:8083//ratingdata/users/"+Userid,UserRating.class);
		
		return userrating.getUserRating().stream().map(rating ->{
			Movie  m =  rt.getForObject("http://localhost:8078/movie/"+rating.getMovieId(),Movie.class);
			return new Catalog(m.getName(),"",rating.getRating());
		}).collect(Collectors.toList());

				//m.getName()
	}

	//	@GetMapping("/catalog")
	//	public Catalog getAllCatalog() {
	//		
	//		return new Catalog("Malamal weekly","Comdey ",4);
	//		
	//	}

}


//here our target is return movies list along with details when  user enter userID