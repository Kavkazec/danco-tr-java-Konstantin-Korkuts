app.controller('BookController', ['$scope','books', function($scope, books) { 
  forecast.success(function(data) {
  	$scope.title = 'asgasga';
    $scope.all = data;
  });
}]);