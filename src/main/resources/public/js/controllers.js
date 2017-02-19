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
	}
	self.gotoGetAllMovies = function()
	{
		self.state = "getAllMovies";
		main.getMovies();
	}
	self.gotoCreateMovie = function()
	{
		self.state = "createMovie";
	}
	self.gotoEditMovie = function()
	{
		self.state = "editMovie";
	}
	self.gotoDeleteMovie = function()
	{
		self.state = "deleteMovie";
	}
	self.getMovieById = function(id)
	{
		main.getMovieById(id);
	}
}]);