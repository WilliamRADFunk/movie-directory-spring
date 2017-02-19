// Main function is to instigate the game timer.
movieDirectoryApp.controller("MainController", ["mainData", function(main)
{
	var self = this;

	self.state = "index";
	self.errors = main.errors;

	self.movie = main.movie;
	self.movies = main.movies;

	self.gotoGetMovie = function()
	{
		self.state = "getMovie";
		main.reset();
	}
	self.gotoGetAllMovies = function()
	{
		self.state = "getAllMovies";
		main.reset();
		main.getMovies();
	}
	self.gotoCreateMovie = function()
	{
		self.state = "createMovie";
		main.reset();
	}
	self.gotoEditMovie = function()
	{
		self.state = "editMovie";
		main.reset();
	}
	self.gotoDeleteMovie = function()
	{
		self.state = "deleteMovie";
		main.reset();
	}
	self.getMovieById = function(id)
	{
		main.reset();
		main.getMovieById(id);
	}
	self.createMovie = function()
	{
		main.createMovie(self.movie.title, self.movie.synopsis, self.movie.optimalSeason, self.movie.worstSeason, self.movie.costLicense, self.movie.licenseLength, self.movie.producedBy);
	}
	self.deleteMovie = function(id)
	{
		main.reset();
		main.deleteMovie(id);
	}
}]);