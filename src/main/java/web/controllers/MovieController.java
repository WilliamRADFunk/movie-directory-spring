package web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import data.entities.Movie;
import data.repositories.MovieRepository;
import web.viewmodels.Echo;

@RestController
public class MovieController{
	
	@RequestMapping(
        value = "html",
        method = RequestMethod.GET,
        produces = "application/json"
    )
    public String index() {
        return "/index.html";
    }
	/**
	 * Put echo.
	 */
	@RequestMapping(
	        value = "/echo",
	        method = RequestMethod.POST,
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE
	    )
    public String putEcho(@RequestBody Echo echo) {
		return echo.getMsg();
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
	/**
	 * Delete movie.
	 */
	@RequestMapping(
	        value = "/movie/{id}",
	        method = RequestMethod.DELETE,
	        produces = "application/json"
	    )
    public Movie deleteMovie(@PathVariable(value="id") int id) {
		
		MovieRepository movRepo = new MovieRepository();

		Movie movie = movRepo.deleteMovie(id);
		if(movie == null) {
			return null;
		}
		else {
			return movie;
		}
    }
	/**
	 * Edit movie.
	 */
	@RequestMapping(
	        value = "/movie",
	        method = RequestMethod.PUT,
	        produces = "application/json"
	    )
    public Movie editMovie(@RequestBody(required=true) Movie m) {
		
		MovieRepository movRepo = new MovieRepository();
		
		int id;
		String title;
		String synopsis;
		int optimalSeason;
		int worstSeason;
		double costLicense;
		int licenseLength;
		String producedBy;
		
		
		try {
			id = m.getId();
			title = m.getTitle();
			synopsis = m.getSynopsis();
			optimalSeason = m.getOptimalSeason();
			worstSeason = m.getWorstSeason();
			costLicense = m.getCostLicense();
			licenseLength = m.getLicenseLength();
			producedBy = m.getProducedBy();
			
			java.util.Date dt = new java.util.Date();
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(dt);
			
			String dateCreated = currentTime;
			String dateModified = currentTime;
			
			Movie mov = new Movie(id, title, synopsis, 0.0, 0.0, optimalSeason, worstSeason, costLicense, licenseLength, producedBy, dateCreated, dateModified);
			Movie movie = movRepo.editMovie(mov);
			
			if(movie == null) {
				return null;
			}
			else {
				return movie;
			}
		}
		catch(Exception e)
		{
			return null;
		}
	}
	/**
	 * Get movie.
	 */
	@RequestMapping(
	        value = "/movie/{id}",
	        method = RequestMethod.GET,
	        produces = "application/json"
	    )
    public Movie getMovie(@PathVariable(value="id") int id) {
		
		MovieRepository movRepo = new MovieRepository();

		Movie movie = movRepo.getMovie(id);
		if(movie == null) {
			return null;
		}
		else {
			return movie;
		}
    }
	/**
	 * List movies.
	 */
	@RequestMapping(
	        value = "/movie",
	        method = RequestMethod.GET,
	        produces = "application/json"
	    )
    public List<Movie> getMovies() {
		
		MovieRepository movRepo = new MovieRepository();

		List<Movie> movies = movRepo.getMovies();
		if(movies == null)
			return null;
		else return movies;
    }
}
