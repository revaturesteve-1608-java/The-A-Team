/**
 * 	location.js
 * 
 * stuff relating to the location viewing
 */


var app = angular.module("batchApp");


//-----------------------------------------------------------------------
//Location Section
	app.controller("locationCtrl", function($scope, locationService){
		$scope.getLocations = locationService.getAllLocations(
				function(response){
					$scope.locations = response.data
				}
			);
	});// end app.controller("locationCtrl")
	
	app.service("locationService", function($http, $q){
		this.getAllLocations = function(callback){
			$http.get("rest/getlocations").then(callback);
		}
	});// end app.service("locationService")



