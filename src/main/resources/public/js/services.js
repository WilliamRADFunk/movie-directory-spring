movieDirectoryApp.factory('mainData', ['$http', function($http)
{
	main = {};
	main.movie = {};
	main.movie.id = 0;
	main.movie.title;
	main.movie.synopsis;
	main.movie.expectedPopularity;
	main.movie.optimalSeason;
	main.movie.worstSeason;
	main.movie.costLicense;
	main.movie.licenseLength;
	main.movie.producedBy;
	main.movie.dateCreated;
	main.movie.dateModified;

	main.movies = {};
	main.movies.list = [];


	main.errors = {};
	main.errors.getMovieError = "";
	main.errors.getMoviesError = "";

	// Gets movie by id and returns it to controller.
	main.getMovieById = function(id)
	{
		$http(
			{
				method: 'GET',
				url: '/movie/' + id
			}).then(function successCallback(response)
			{
				if(response.data !== null)
				{
					main.movie.id = response.data.id;
					main.movie.title = response.data.title;
					main.movie.synopsis = response.data.synopsis;
					main.movie.expectedPopularity = response.data.expectedPopularity;
					main.movie.optimalSeason = response.data.optimalSeason;
					main.movie.worstSeason = response.data.worstSeason;
					main.movie.costLicense = response.data.costLicense;
					main.movie.licenseLength = response.data.licenseLength;
					main.movie.producedBy = response.data.producedBy;
					main.movie.dateCreated = response.data.dateCreated;
					main.movie.dateModified = response.data.dateModified;
				}
				else
				{
					main.errors.getMovieError = "No movie found with that id."
				}
			}, function errorCallback(response)
			{
				main.errors.getMovieError = response.statusText;
			});
	}
	// Gets all movies and returns them to controller.
	main.getMovies = function()
	{
		$http(
			{
				method: 'GET',
				url: '/movie'
			}).then(function successCallback(response)
			{
				if(response.data !== null)
				{
					main.movies.list = response.data;
				}
				else
				{
					main.errors.getMoviesError = "No movies found."
				}
			}, function errorCallback(response)
			{
				main.errors.getMoviesError = response.statusText;
			});
	}

	// Pass one-way data to those dependent on the service.
	return main;
}]);