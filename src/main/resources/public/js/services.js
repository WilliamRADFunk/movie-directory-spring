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

	main.response = {};
	main.response.isCreated = false;
	main.response.isDeleted = false;
	main.response.isEdited = false;

	main.errors = {};
	main.errors.getMovieError = "";
	main.errors.getMoviesError = "";
	main.errors.createMovieError = "";
	main.errors.editMovieError = "";
	main.errors.deleteMovieError = "";

	// Creates a new movie from the information given by user
	main.createMovie = function(title, synopsis, optimalSeason, worstSeason, costLicense, licenseLength, producedBy)
	{
		if(	title === null || title === "" || title === undefined ||
			synopsis === null || synopsis === "" || synopsis === undefined ||
			optimalSeason === null || optimalSeason === "" || optimalSeason === undefined ||
			worstSeason === null || worstSeason === "" || worstSeason === undefined ||
			costLicense === null || costLicense === "" || costLicense === undefined ||
			licenseLength === null || licenseLength === "" || licenseLength === undefined ||
			producedBy === null || producedBy === "" || producedBy === undefined)
		{
			main.errors.createMovieError = "All fields must be filled out.";
			return;
		}
		else if(optimalSeason < 0 || optimalSeason > 3)
		{
			main.errors.createMovieError = "Optimal Season must be 0, 1, 2, or 3";
			return;
		}
		else if(worstSeason < 0 || worstSeason > 3)
		{
			main.errors.createMovieError = "Worst Season must be 0, 1, 2, or 3";
			return;
		}
		else if(costLicense < 1000 || costLicense > 10000)
		{
			main.errors.createMovieError = "Cost of License must be between $1,000 and $10,000";
			return;
		}
		else if(licenseLength < 12 || licenseLength > 52)
		{
			main.errors.createMovieError = "License Duration must be 12 and 52 weeks";
			return;
		}
		else
		{
			$http(
			{
				method: 'POST',
				url: '/movie',
				data: {
					"title": title,
					"synopsis": synopsis,
					"optimalSeason": optimalSeason,
					"worstSeason": worstSeason,
					"costLicense": costLicense,
					"licenseLength": licenseLength,
					"producedBy": producedBy
				}
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

					main.response.isCreated = true;
				}
				else
				{
					main.errors.createMovieError = "Failed to create your movie."
				}
			}, function errorCallback(response)
			{
				main.errors.createMovieError = response.statusText;
			});
		}
	}
	// Deletes movie by id and returns it to controller.
	main.deleteMovie = function(id)
	{
		$http(
			{
				method: 'DELETE',
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

					main.response.isDeleted = true;
				}
				else
				{
					main.errors.deleteMovieError = "No movie found with that id."
				}
			}, function errorCallback(response)
			{
				main.errors.deleteMovieError = response.statusText;
			});
	}
	// Edits a new movie with provided id using the information given by user
	main.editMovie = function(id, title, synopsis, optimalSeason, worstSeason, costLicense, licenseLength, producedBy)
	{
		console.log(title, synopsis, optimalSeason, worstSeason, costLicense, licenseLength, producedBy);
		if(	title === null || title === "" || title === undefined ||
			synopsis === null || synopsis === "" || synopsis === undefined ||
			optimalSeason === null || optimalSeason === "" || optimalSeason === undefined ||
			worstSeason === null || worstSeason === "" || worstSeason === undefined ||
			costLicense === null || costLicense === "" || costLicense === undefined ||
			licenseLength === null || licenseLength === "" || licenseLength === undefined ||
			producedBy === null || producedBy === "" || producedBy === undefined)
		{
			main.errors.editMovieError = "All fields must be filled out.";
			return;
		}
		else if(optimalSeason < 0 || optimalSeason > 3)
		{
			main.errors.editMovieError = "Optimal Season must be 0, 1, 2, or 3";
			return;
		}
		else if(worstSeason < 0 || worstSeason > 3)
		{
			main.errors.editMovieError = "Worst Season must be 0, 1, 2, or 3";
			return;
		}
		else if(costLicense < 1000 || costLicense > 10000)
		{
			main.errors.editMovieError = "Cost of License must be between $1,000 and $10,000";
			return;
		}
		else if(licenseLength < 12 || licenseLength > 52)
		{
			main.errors.editMovieError = "License Duration must be 12 and 52 weeks";
			return;
		}
		else
		{
			$http(
			{
				method: 'PUT',
				url: '/movie',
				data: {
					"id": id,
					"title": title,
					"synopsis": synopsis,
					"optimalSeason": optimalSeason,
					"worstSeason": worstSeason,
					"costLicense": costLicense,
					"licenseLength": licenseLength,
					"producedBy": producedBy
				}
			}).then(function successCallback(response)
			{
				console.log(response.data);
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

					main.response.isEdited = true;
				}
				else
				{
					main.errors.editMovieError = "Failed to edit your movie."
				}
			}, function errorCallback(response)
			{
				main.errors.editMovieError = response.statusText;
			});
		}
	}
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
	// Reset the main.movie and main.movies content
	main.reset = function()
	{
		main.movie.id = 0;
		main.movie.title = "";
		main.movie.synopsis = "";
		main.movie.expectedPopularity = 0.0;
		main.movie.optimalSeason = 0;
		main.movie.worstSeason = 0;
		main.movie.costLicense = 0.0;
		main.movie.licenseLength = 0;
		main.movie.producedBy = "";
		main.movie.dateCreated = "";
		main.movie.dateModified = "";

		main.movies.list = [];

		main.response.isCreated = false;
		main.response.isDeleted = false;
		main.response.isEdited = false;
	}

	// Pass one-way data to those dependent on the service.
	return main;
}]);