app.controller('AuthorizationController', ['$scope','$http',function($scope,$http){
	$scope.title = 'Authorization';
	$scope.login = '';
	$scope.password = '';
	$scope.result = function(){
		confirm(this.login + " " + this.password);
	};
	$scope.findUser = function() {
		var data = 'login=' + $scope.login + '&password=' + $scope.password;
		var isSuccess = false;
		
		var user = $http({
	        url: 'http://localhost:8080/webrest/users/find',
	        method: "POST",
	        data: data
	    });
	    user.then(function (response) {
			if (response.data){
				isSuccess = true;
				alert(isSuccess)
			};
		}, function (response) {
			alert("Service not Exists");
			alert(response.status);
			alert(response.statusText);
			alert(response.headers());
		});
		$scope.login = '';
		$scope.password = '';
	}
}]);