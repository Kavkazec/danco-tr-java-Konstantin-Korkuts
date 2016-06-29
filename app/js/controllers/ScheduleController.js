app.controller('ScheduleController', ['$scope','$http','groupes','lecturers',function($scope,$http,groupes,lecturers) { 
 	$scope.myDate = new Date().toLocaleString();
 	$scope.date = new Date();
 	$scope.selectedGroupe = '';
 	$scope.findByGroupe = function(){
 		var years = $scope.date.getFullYear();
 		var months = $scope.date.getMonth()+1;
 		var days = $scope.date.getDate();
 		var result = years+"-"+months+"-"+days;
 		var byGroupe = 'title=' + $scope.selectedGroupe + '&date=' + result;
		
		
		var user = $http({
	        url: 'http://localhost:8080/webrest/schedules/find/by/groupe',
	        method: "POST",
	        data: byGroupe
	    }).success(function(data) { 
              $scope.groupeList = data;
            }) 
            .error(function(err) { 
              return err; 
            }); 
	}
	$scope.findByLecturer = function(){
		var years = $scope.date.getFullYear();
 		var months = $scope.date.getMonth()+1;
 		var days = $scope.date.getDate();
 		var result = years+"-"+months+"-"+days;
 		var byLecturer = 'fullName=' + $scope.selectedLecturer + '&date=' + result;
		
		var user = $http({
	        url: 'http://localhost:8080/webrest/schedules/find/by/lecturer',
	        method: "POST",
	        data: byLecturer
	    }).success(function(data) { 
              $scope.lecturerList = data;
            }) 
            .error(function(err) { 
              return err; 
        }); 
	}
 	groupes.success(function(data) {
   	 $scope.allGroupes = data;
 	});
 	lecturers.success(function(data) {
   	 $scope.allLecturers = data;
 	});
}]);