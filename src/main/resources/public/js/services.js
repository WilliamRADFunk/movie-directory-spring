movieDirectoryApp.factory('mainData', ['$http', function($http)
{
	var balance = 10000;
	main = {};
	
	main.state = "index";

	// Pass one-way data to those dependent on the service.
	return main;
}]);