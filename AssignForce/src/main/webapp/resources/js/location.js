/**
 * location.js
 * 
 * stuff relating to the location viewing
 */

var app = angular.module("batchApp");

// -----------------------------------------------------------------------
// Location Section
app.controller("locationCtrl", function($scope, $window, locationService) {
	$scope.getLocations = locationService.getAllLocations(function(response) {
		$scope.locations = response.data
	});

	//Submit location data and have $window refresh the page
	$scope.submitAndVerify = function(nLocation) {
		$scope.updateTask = locationService.saveLocation(nLocation);
		$scope.createLocation = !$scope.createLocation;
		$window.location.reload();
	}
});// end app.controller("locationCtrl")

app.service("locationService", function($http, $q) {
	this.getAllLocations = function(callback) {
		$http.get("rest/getlocations").then(callback);
	}

	this.saveLocation = function(nLocation) {
		//Rest call to the spring rest controller
		var promise = $http.post('rest/saveLocation', nLocation).then(function(response) {
		}, function(error) {
			
		})
	}//end saveLocation(nLocation)
});// end app.service("locationService")

