/**
 * allbatches.js
 * 
 * 
 * js for allbatches
 */


var app = angular.module("batchApp");


app.controller("allBatchCtrl", function($scope, $location, allBatchService, transferService) {
	$scope.getBatches = allBatchService.getAllBatches(function(response) {
		$scope.Batches = response.data
	});
	
	$scope.createDate = function(ms){
		return allBatchService.createDate(ms);
	}
	
	//Saves the batch id in transferService then route to the createbatches.html
	$scope.editBatch = function(id){
		transferService.set(id);
		$location.path("/createbatches");
	}

});// end app.controller("allBatchCtrl")

app.service("allBatchService", function($http, $q) {
	
	//Gets all batches
	this.getAllBatches = function(callback) {
		$http.get("rest/batches").then(callback);
	}
	
	this.createDate = function(ms){
		var date = new Date(ms).toDateString();
		
		//Future implementation
		if(date == "Invalid Date"){
			
			return "";
		}
		return date;
	}// end createDate
			

});// end app.service("batchService")

