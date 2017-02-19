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
import web.viewmodels.EchoViewModel;
import web.viewmodels.MovieViewModel;

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
	        method = RequestMethod.PUT,
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE
	    )
    public EchoViewModel putEcho(@RequestBody EchoViewModel echo) {
		return echo;
	}
	/**
	 * Create movie.
	 */
	@RequestMapping(
	        value = "/movie",
	        method = RequestMethod.POST,
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE
	    )
    public MovieViewModel createMovie(@RequestBody(required=true) MovieViewModel m) {
		
		MovieRepository movRepo = new MovieRepository();
		
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		
		double expectedPopularity = ((double)((int)Math.ceil(Math.random() * 10))) / 10.0;
		double actualPopularity = ((double)((int)Math.ceil(Math.random() * 10))) / 10.0;
		
		String dateCreated = currentTime;
		String dateModified = currentTime;
		
		Movie mov = new Movie(0, m.getTitle(), m.getSynopsis(), expectedPopularity, actualPopularity, m.getOptimalSeason(), m.getWorstSeason(), m.getCostLicense(), m.getLicenseLength(), m.getProducedBy(), dateCreated, dateModified);
		Movie movie = movRepo.createMovie(mov);
		
		if(movie == null) {
			return null;
		}
		else {
			MovieViewModel mvm = new MovieViewModel(movie);
			return mvm;
		}
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
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE
	    )
    public MovieViewModel editMovie(@RequestBody(required=true) MovieViewModel m) {
		
		MovieRepository movRepo = new MovieRepository();
		
		try {
			
			java.util.Date dt = new java.util.Date();
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(dt);
			
			String dateCreated = currentTime;
			String dateModified = currentTime;
			
			Movie mov = new Movie(m.getId(), m.getTitle(), m.getSynopsis(), 0.0, 0.0, m.getOptimalSeason(), m.getWorstSeason(), m.getCostLicense(), m.getLicenseLength(), m.getProducedBy(), dateCreated, dateModified);
			Movie movie = movRepo.editMovie(mov);
			
			if(movie == null) {
				return null;
			}
			else {
				MovieViewModel mvm = new MovieViewModel(movie);
				return mvm;
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
