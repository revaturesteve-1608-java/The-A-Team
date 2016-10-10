/**
 * 
 */

var app = angular.module("batchApp", [ 'ngRoute' ]);
app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/home', {
		templateUrl : 'home.html'
	}).when('/viewbatches', {
		templateUrl : 'viewbatches.html'
	}).when('/viewtrainers', {
		templateUrl : 'viewtrainers.html',
		controller : 'trainerCtrl'
	}).when('/createbatches', {
		templateUrl : 'createbatches.html'
	}).when('/locations', {
		templateUrl : 'locations.html'
	});
} ]);

app.controller('trainerCtrl', function($scope, trainerService) {
	console.log('Getting Trainers');
	$scope.getTrainers = trainerService.getTrainers();
})

app.service('trainerService', function($http, $q) {

	this.getTrainers = function() {
		var tpromise = $http.get('/viewtrainers').then(function(response) {
			console.log(response + 'I think I got the trainers')
		}, function(error) {
			console.log($q.reject(error))
		})

	}
})

app.controller('viewBatchCtrl', function($scope, ViewBatchService) {
	console.log('Getting Batches');
	$scope.getBatches = ViewBatchService.getBatches();
})

app.service('viewBatchService', function($http, $q) {

	this.getBatches = function() {
		var bpromise = $http.get('/viewbatches').then(function(response) {
			console.log(response + 'I think I got the batches')
		}, function(error) {
			console.log($q.reject(error))
		})
	}
})
