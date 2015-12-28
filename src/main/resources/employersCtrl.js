var app = angular.module('glassdoor', []); 

app.controller('employersCtrl', function($scope) {

  $scope.baseUrl = "http://192.168.1.33/glassdoor/employers";

  $scope.submit = function() {
    $scope.url = $scope.baseUrl+"?partnerId="+$scope.partnerId+"&key="+$scope.partnerKey;
    $http.get($scope.url)
      .success(function (response) {
        $scope.companies = response.response.employers;
      })
      .error(function (data, status) {
        alert('failure');
      });
  };
});
