/**
 * 
 */
var app = angular.module("batchApp");

app.controller('batchCtrl', function($scope, batchService, trainerService, locationService){
	
	$scope.getCurrs = batchService.getCurrs(
			//passed in callback
			function(response){
				console.log(response)
				$scope.currs = response.data;
			})
			$scope.today = function(){
		$scope.dt = new Date();
	};
	
	$scope.getTrainers = trainerService.getAllTrainers(
			function(response){
				$scope.trainers = response.data
			}
		);
	
	$scope.getTopics = batchService.getTopics(
			function(response){
				$scope.topics = response.data
			}
		);
	
	$scope.getRooms = batchService.getRooms(
			function(response){
				console.log(response)
				$scope.rooms = response.data
			}
		);
	
	$scope.saveBatch = function(batchName, topic, curr, trainer, room, date, date2){
		console.log('Trying to save...')
		$scope.updateTask = 
			batchService.saveBatch(batchName, topic, curr, trainer, room, date, date2);
	}

	
	//////Date Data////////////////////////
			$scope.today = function(){
		$scope.dt = new Date();
	};
	
	$scope.today();
	
	$scope.clear = function(){
		$scope.dt = null;
	};
	
	$scope.inlineOptions = {
			customClass : getDayClass,
			minDate : new Date(),
			showWeeks : true
	};
	
	$scope.dateOptions = {
			dateDisabled: disabled,
			formatYear: 'yy',
			minDate: new Date(),
			startingDay: 1
	};
	
	//Disable Weekend
	function disabled(data){
		var date = data.date,
		mode = data.mode;
		
		return mode == 'day' && (date.getDay() === 0 || date.getDay() === 6);
	}
	
	$scope.toggleMin = function(){
		$scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
		$scope.dateOptions.minDate = $scope.inlineOptions.minDate;
	};
	
	$scope.toggleMin();
	
	$scope.open1 = function(){
		$scope.popup1.opened = true;
	};
	
	$scope.open2 = function(){
		$scope.popup2.opened = true;
	};
	
	$scope.setDate = function(year, month, day){
		$scope.dt = new Date(year, month, day);
	};
	
	$scope.format = 'dd-MMM-yy';
	
	$scope.popup1 = {
		opened: false
	};
	
	$scope.popup2 = {
			opened: false
		};
	
	  var tomorrow = new Date();
	  tomorrow.setDate(tomorrow.getDate() + 1);
	  var afterTomorrow = new Date();
	  afterTomorrow.setDate(tomorrow.getDate() + 1);
	  $scope.events = [
	    {
	      date: tomorrow,
	      status: 'full'
	    },
	    {
	      date: afterTomorrow,
	      status: 'partially'
	    }
	  ];
	
	
	function getDayClass(data){
		var date = data.date,
		mode = data.mode;
		
		if (mode === 'day'){
			var dayToCheck = new Date(date).setHours(0,0,0,0);
			
			for(var i = 0; i < $scope.events[i].length; i++){
				var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);
				
				if (dayToCheck === currentDay){
					return $scope.events[i].status;
				}
			}
		}
		return '';
	}
});

app.service('batchService', function($http, $q){
	console.log('calling batchService');
	
	this.getCurrs = function(callback){
		$http.get('rest/curriculum').then(callback);
	}
	
	this.getTopics = function(callback){
		$http.get('rest/topics').then(callback);
	}
	
	this.getRooms = function(callback){
		$http.get('rest/rooms').then(callback);
	}
	
	this.saveBatch = function(batchName, topic, curr, trainer, room, date, date2){
		console.log('hitting saveBatch js')
		var batchObj = {};
		
		batchObj.batchName = batchName;
		batchObj.topic = topic;
		batchObj.curr = curr;
		batchObj.trainer = trainer;
		batchObj.room = room;
		batchObj.date = date;
		batchObj.date2 = date2;
		
		
		var promise = $http.post('rest/savebatch', batchObj).
		then(
				function(response){
					console.log(response + ' Hope it worked');
				},
				
				function(error){
					console.log($q.reject(error));
				}
		)
	}
	
	
})
	

