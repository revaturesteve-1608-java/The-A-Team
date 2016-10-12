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
	
	app.controller('trainerCtrl', function($scope, trainerService){
		console.log('Getting Trainers');
		$scope.getTrainers = trainerService.getAllTrainers(
			function(response){
				$scope.trainers = response.data
			}
		);
	})
	
	app.service('trainerService', function($http, $q){
		
		this.getAllTrainers = function(callback){
			$http.get('rest/trainer').then(callback);
		}
		
//		this.getTrainers = function(){
//			var tpromise = $http.get('rest/trainer').then(
//				function(response){
//					console.log(response);
//				},
//				function(error){
//					console.log($q.reject(error))
//				}
//			)
//		}
	});