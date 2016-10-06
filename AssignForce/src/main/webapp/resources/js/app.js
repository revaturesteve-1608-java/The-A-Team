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
			templateUrl : 'viewtrainers.html'
		}).
		when('/createbatches', {
			templateUrl : 'createbatches.html'
		});
	}]);
	
	app.controller('activeCtrl', function($scope){
		
	});