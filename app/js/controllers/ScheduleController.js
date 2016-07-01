app.controller('ScheduleController', ['$scope','$http','groupes','lecturers','scheduleByGroupe','scheduleByLecturer',function($scope,$http,groupes,lecturers,scheduleByGroupe,scheduleByLecturer) { 
 	$scope.myDate = new Date().toLocaleString();
 	$scope.date = new Date();
 	$scope.selectedGroupe = '';
 	$scope.findByGroupe = function(){
 		var years = $scope.date.getFullYear();
 		var months = $scope.date.getMonth()+1;
 		var days = $scope.date.getDate();
 		var result = years+"-"+months+"-"+days;

        scheduleByGroupe.async($scope.selectedGroupe, result).success(function(data){
			$scope.groupeList = data;
        });
	}
	$scope.findByLecturer = function(){
		var years = $scope.date.getFullYear();
 		var months = $scope.date.getMonth()+1;
 		var days = $scope.date.getDate();
 		var result = years+"-"+months+"-"+days;

 		scheduleByLecturer.async($scope.selectedLecturer, result).success(function(data){
			$scope.lecturerList = data;
        });
	}
 	groupes.success(function(data) {
   	 $scope.allGroupes = data;
 	});
 	lecturers.success(function(data) {
   	 $scope.allLecturers = data;
 	});
}]);