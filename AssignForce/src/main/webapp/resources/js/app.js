/**
 * 
 */

var app = angular.module("batchApp", ['ngRoute']);
	app.config(['$routeProvider', function($routeProvider){
		$routeProvider.
		when('/home', {
			templateUrl : 'home.html'
		}).
		when('/viewbatches', {
			templateUrl : 'viewbatches.html'
		}).
		when('/viewtrainers', {
			templateUrl : 'viewtrainers.html',
			controller : 'trainerCtrl'
		}).
		when('/createbatches', {
			templateUrl : 'createbatches.html'
		}).
		when('/locations', {
			templateUrl : 'locations.html'
		});
	}]);
//-----------------------------------------------------------------------
//Trainer Section
	app.controller('trainerCtrl', function($scope, trainerService){
//		console.log('Getting Trainers');
//		console.log('takin care of business');
		$scope.testingVar = 12345;
		$scope.getTrainers = trainerService.getAllTrainers(
			function(response){
				$scope.trainers = response.data
			}
		);
//		console.log('BallyHoo');
	})
	
	app.service('trainerService', function($http, $q){
		
		this.getAllTrainers = function(callback){
			$http.get('rest/trainer').then(callback);
		}
		
		this.getTrainers = function(){
//			console.log('and workin overtime');
			var tpromise = $http.get('rest/trainer').then(
					function(response){
//						console.log('its alright');
						console.log(response);
//						console.log(response + 'I think I got the trainers')
					},
					function(error){
						console.log('NAAW');
						console.log($q.reject(error))
					}
			)
			
		}
	})
	
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
	
	
	
	