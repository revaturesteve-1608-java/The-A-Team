/**
 * 
 */
//Basic routing information
var app = angular.module("batchApp", ['ngRoute', 'ui.bootstrap']);
	
	//Single page application(SPA) using ngRoute and the $routeProvider
	app.config(['$routeProvider', function($routeProvider){
		$routeProvider.
		when('/home', {
			templateUrl : 'home.html'
		}).
		when('/viewtrainers', {
			templateUrl : 'viewtrainers.html',
			controller: 'trainerCtrl'
		}).
		when('/createbatches', {
			templateUrl : 'createbatches.html',
			controller : 'batchCtrl'
		}).
		when('/locations', {
			templateUrl : 'locations.html',
			controller : 'locationCtrl'
		}).
		when('/allbatches', {
			templateUrl : 'allbatches.html',
			controller : 'allBatchCtrl'
		})
	}]);


	


// -----------------------------------------------------------------------
// Trainer Section
app.controller('trainerCtrl', function($scope, trainerService) {
	
	//Retrieves all trainers in the database
	$scope.getTrainers = trainerService.getAllTrainers(function(response) {
		
		$scope.trainers = response.data
	});
	$scope.createDate = function(ms) {
		var s = (1000 * ms);
		var date = new Date(ms);
		var months = [ 'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug',
				'Sep', 'Oct', 'Nov', 'Dec' ];
		var year = date.getFullYear();
		var month = months[date.getMonth()];
		var date = date.getDate();
		var time = date + ' ' + month + ' ' + year;

		if (date == 'Invalid Date') {
			//Future Implementation
		}
		return String(time);
	};
	
})


app.service('trainerService', function($http, $q) {

	this.getAllTrainers = function(callback) {
		$http.get('rest/trainer').then(callback);
	}

	this.getTrainers = function() {
		
		var tpromise = $http.get('rest/trainer').then(function(response) {
			
		}, function(error) {
			

		})
	}
	
});
	
	//Saves the batchID from view batches to be used to edit a batch in createbatch.js
	app.factory('transferService', function() {
		 var savedData = {}
		 
		 function set(data) {
		   savedData = data;
		 }
		 function get() {
		  return savedData;
		 }

		 return {
		  set: set,
		  get: get
		 }

	});


	
