package web.viewmodels;

import data.entities.Movie;

public class MovieViewModel {
	
	private int id;
	private String title;
	private String synopsis;
	private double expectedPopularity;
	private double actualPopularity;
	private int optimalSeason;
	private int worstSeason;
	private double costLicense;
	private int licenseLength;
	private String producedBy;
	private String dateCreated;
	private String dateModified;
	
	public MovieViewModel() {}
	
	public MovieViewModel(Movie m) {
		this.id = m.getId();
		this.title = m.getTitle();
		this.synopsis = m.getSynopsis();
		this.expectedPopularity = m.getExpectedPopularity();
		this.actualPopularity = m.getActualPopularity();
		this.optimalSeason = m.getOptimalSeason();
		this.worstSeason = m.getWorstSeason();
		this.costLicense = m.getCostLicense();
		this.licenseLength = m.getLicenseLength();
		this.producedBy = m.getProducedBy();
		this.dateCreated = m.getDateCreated();
		this.dateModified = m.getDateModified();
	}
	
	public MovieViewModel(int id, String title, String synopsis, double expectedPopularity, double actualPopularity, int optimalSeason, int worstSeason, double costLicense, int licenseLength, String producedBy, String dateCreated, String dateModified) {
		this.id = id;
		this.title = title;
		this.synopsis = synopsis;
		this.expectedPopularity = expectedPopularity;
		this.actualPopularity = actualPopularity;
		this.optimalSeason = optimalSeason;
		this.worstSeason = worstSeason;
		this.costLicense = costLicense;
		this.licenseLength = licenseLength;
		this.producedBy = producedBy;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
	}
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public double getExpectedPopularity() {
		return expectedPopularity;
	}

	public double getActualPopularity() {
		return actualPopularity;
	}

	public int getOptimalSeason() {
		return optimalSeason;
	}

	public int getWorstSeason() {
		return worstSeason;
	}

	public double getCostLicense() {
		return costLicense;
	}

	public int getLicenseLength() {
		return licenseLength;
	}

	public String getProducedBy() {
		return producedBy;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public String getDateModified() {
		return dateModified;
	}
}
