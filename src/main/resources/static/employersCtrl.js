var app = angular.module('glassdoor', []);

app.controller('employersCtrl', function($scope, $http) {

	$scope.baseUrl = "http://192.168.1.33:8080/glassdoor/employers";

	$scope.submit = function() {
		$scope.url = $scope.baseUrl + "?partnerId=" + $scope.partnerId
				+ "&partnerKey=" + $scope.partnerKey + "&location="
				+ $scope.location;
		$http.get($scope.url).success(function(response) {
			$scope.companies = response;
		}).error(function(data, status) {
			alert('failure');
		});
	};
});
