package web;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import data.entities.Movie;

@RestController
public class MovieController{
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
    public Movie greeting(@RequestParam(value="name", defaultValue="World") String name) {
		int id = 100;
		String title = String.format(template, name);
		String synopsis = String.valueOf(counter);
		double expectedPopularity = 0.5;
		double actualPopularity = 0.5;
		int optimalSeason = 0;
		int worstSeason = 3;
		double costLicense = 1000;
		int licenseLength = 24;
		String producedBy = "Game Creator";
		String dateCreated = new java.util.Date().toString();
		String dateModified = new java.util.Date().toString();
		
        return new Movie(id, title, synopsis, expectedPopularity, actualPopularity, optimalSeason, worstSeason, costLicense, licenseLength, producedBy, dateCreated, dateModified);
    }
}
