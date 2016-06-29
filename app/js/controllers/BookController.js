app.controller('BookController', ['$scope','books', function($scope, books) { 
	$scope.title = 'E-library';
 	$scope.myDate = new Date();
	$scope.orderBy = function(x) {
    	$scope.myOrderBy = x;
  	}
  books.success(function(data) {
    $scope.all = data;
  });
}]);