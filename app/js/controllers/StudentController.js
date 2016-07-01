app.controller('StudentController',['$scope','$http','student','verification',function($scope,$http,student,verification){
	student.success(function(data) {
   	 $scope.oneStudent = data;
 	});
 	verification.success(function(data) {
   	 $scope.allVerification = data;
 	});
 	$scope.updateInterest = function(){
 		alter($scope.interests);
 		var data = 'interests=' + $scope.interests;
 		var newInterests = $http({
	        url: 'http://localhost:8080/webrest/student/1',
	        method: "PUT",
	        data: newInterests
	    }).success(function(data) { 
              alter('Success!')
            }) 
            .error(function(err) { 
              return err; 
            }); 
 	}

 	$scope.updatePassword = function(){
 		alter($scope.newPassword);
 		var password = 'password=' + $scope.newPassword;
 		var newInterests = $http({
	        url: 'http://localhost:8080/webrest/user/6',
	        method: "PUT",
	        data: password
	    }).success(function(data) { 
              alter('Success!')
            }) 
            .error(function(err) { 
              return err; 
            }); 
 	}
}]);