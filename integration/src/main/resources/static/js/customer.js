var app = angular.module("customer", ['ui.bootstrap','dialogs.main','pascalprecht.translate','dialogs.default-translations']);

app.controller('CustCtrl', function($scope, $location,$http,$rootScope,$timeout,$translate,dialogs) {
	var self = this;
	/*
	 * $http.get('resource/').then(function(response) { self.greeting =
	 * response.data; })
	 */
	$scope.SubmitData = function() {
		// var CustInfo=$scope.CustInfo;
		// get sessionID value
		var dlg=null;
		
		if ($location.absUrl().indexOf('sessionID') == -1) {
			$scope.CustInfo.sessionID = "";
		}
		else
		{
			$scope.CustInfo.sessionID = $location.absUrl().substring(
					$location.absUrl().indexOf('sessionID')+10);
		}
		 
		dialogs.wait('客户数据上传','请稍等',100);
		 
		$http.post('/customer', $scope.CustInfo).success(function(data) {
			$rootScope.$broadcast('dialogs.wait.complete');
		});
		

		// var urlParameter=$location.search('sessionID');
		// $scope.CustInfo.create({"sessionID":"abc"});

	}
});
