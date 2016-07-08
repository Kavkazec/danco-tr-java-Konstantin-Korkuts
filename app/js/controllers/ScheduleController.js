app.controller('ScheduleController', ['$scope','$http','groupes','lecturers',function($scope,$http,groupes,lecturers) { 
 	$scope.myDate = new Date().toLocaleString();
 	$scope.date = new Date();
 	$scope.selectedGroupe = '';
 	$scope.findByGroupe = function(){
 		var years = $scope.date.getFullYear();
 		var months = $scope.date.getMonth();
 		var days = $scope.date.getDate();
 		alert(years+"-"+months+"-"+days);
 		var byGroupe = 'title=' + $scope.selectedGroupe + '&date=' + $scope.date;
		var isSuccessOne = false;
		
		
		var user = $http({
	        url: 'http://localhost:8080/webrest/schedules/find/by/groupe',
	        method: "POST",
	        data: byGroupe
	    });
	    user.then(function (response) {
			if (response.data){
				isSuccessOne = true;
				alert(isSuccessOne)
			};
		}, function (response) {
			alert("Service not Exists");
			alert(response.status);
			alert(response.statusText);
			alert(response.headers());
		});
		alert(isSuccessOne);
	}
	$scope.findByLecturer = function(){
 		var byLecturer = 'fullName=' + $scope.selectedGroupe + '&date=' + $scope.date;
		var isSuccessTwo = false;
		
		var user = $http({
	        url: 'http://localhost:8080/webrest/schedules/find/by/lecturers',
	        method: "POST",
	        data: two
	    });
	    user.then(function (response) {
			if (response.data){
				isSuccessTwo = true;
				alert(isSuccessTwo)
			};
		}, function (response) {
			alert("Service not Exists");
			alert(response.status);
			alert(response.statusText);
			alert(response.headers());
		});
		alert(isSuccessTwo);
	}
 	groupes.success(function(data) {
   	 $scope.allGroupes = data;
 	});
 	lecturers.success(function(data) {
   	 $scope.allLecturers = data;
 	});
}]);