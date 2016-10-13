/**
 * allbatches.js
 * 
 * 
 * js for allbatches
 */


var app = angular.module("batchApp");


app.controller("allBatchCtrl", function($scope, allBatchService) {
	console.log("uhhhh");
	$scope.getBatches = allBatchService.getAllBatches(function(response) {
		console.log("did it make it?");
		$scope.Batches = response.data
	});
	
	$scope.createDate = function(ms){
		return allBatchService.createDate(ms);
	}

});// end app.controller("allBatchCtrl")

app.service("allBatchService", function($http, $q) {
	this.getAllBatches = function(callback) {
		$http.get("rest/batches").then(callback);
	}
	
	this.createDate = function(ms){
		var date = new Date(ms).toDateString();

		if(date == "Invalid Date"){
			console.log("here");
			return "";
		}
		return date;
	}// end createDate
			

});// end app.service("batchService")

