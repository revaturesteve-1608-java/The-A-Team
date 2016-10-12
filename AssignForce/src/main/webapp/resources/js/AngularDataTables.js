var app = angular.module('showcase', ['datatables']).controller('WithAjaxCtrl', WithAjaxCtrl);

function WithAjaxCtrl(DTOptionsBuilder, DTColumnBuilder) {
    var vm = this;
    vm.dtOptions = DTOptionsBuilder.fromSource('resources/js/json/demoDataTable.json')
        .withPaginationType('full_numbers');
    vm.dtColumns = [
        DTColumnBuilder.newColumn('B_ID').withTitle('Batch ID'),
        DTColumnBuilder.newColumn('B_START_DATE').withTitle('Batch Start Date'),
        DTColumnBuilder.newColumn('B_END_DATE').withTitle('Batch End Date'),
        DTColumnBuilder.newColumn('TOP_NAME').withTitle('Topic'),
        DTColumnBuilder.newColumn('CUR_NAME').withTitle('Curriculum'),
        DTColumnBuilder.newColumn('R_NAME').withTitle('Room'),
        DTColumnBuilder.newColumn('BS_NAME').withTitle('Status'),
        DTColumnBuilder.newColumn('T_FIRSTNAME').withTitle('Trainer First Name'),
        DTColumnBuilder.newColumn('T_LASTNAME').withTitle('Trainer Last Name')
    ];
    
    app.config(['$routeProvider', function($routeProvider){
		$routeProvider.
		when('/viewcurrentbatches', {
			templateUrl : 'viewbatches.html'
		}).
		when('/viewupcomingbatches', {
			templateUrl : 'viewbatches.html'
		}).
		when('/viewendedbatches', {
			templateUrl : 'viewbatches.html',
		});
	}]);
}