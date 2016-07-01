app.controller('AuthorizationController', ['$scope','$http','authorization',function($scope,$http,authorization){
	$scope.title = 'Authorization';
	$scope.login = '';
	$scope.password = '';
	$scope.findUser = function() {
		authorization.async($scope.login, $scope.password).success(function(){
			$scope.user = data;
		});
		$scope.login = '';
		$scope.password = '';
	}
}]);