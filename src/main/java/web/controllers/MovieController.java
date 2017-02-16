package web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import data.entities.Movie;
import data.repositories.MovieRepository;

@RestController
public class MovieController{
	
	@RequestMapping(
        value = "/",
        method = RequestMethod.GET,
        produces = "application/json"
    )
    public String index() {
        return "{\"Echo\":\"Hello Java Spring Framework\"}";
    }
	/**
	 * Create movie.
	 */
	@RequestMapping(
	        value = "/movie",
	        method = RequestMethod.POST,
	        produces = "application/json"
	    )
    public Movie createMovie(
    		@RequestParam(required=true) String title,
    		@RequestParam(required=true) String synopsis,
    		@RequestParam(required=true) int optimalSeason,
    		@RequestParam(required=true) int worstSeason,
    		@RequestParam(required=true) double costLicense,
    		@RequestParam(required=true) int licenseLength,
    		@RequestParam(required=true) String producedBy
    	) {
		
		MovieRepository movRepo = new MovieRepository();
		
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		
		double expectedPopularity = ((double)((int)Math.ceil(Math.random() * 10))) / 10.0;
		double actualPopularity = ((double)((int)Math.ceil(Math.random() * 10))) / 10.0;
		
		String dateCreated = currentTime;
		String dateModified = currentTime;
		
		Movie mov = new Movie(0, title, synopsis, expectedPopularity, actualPopularity, optimalSeason, worstSeason, costLicense, licenseLength, producedBy, dateCreated, dateModified);
		Movie movie = movRepo.createMovie(mov);
		
		if(movie == null) return null;
		else return movie;
    }
}
