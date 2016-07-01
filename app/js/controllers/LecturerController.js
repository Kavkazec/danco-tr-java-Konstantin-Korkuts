app.controller('LecturerController', ['$scope','$http','lecturer','lecturersSubject', function($scope,$http,lecturer,lecturersSubject){
	lecturer.success(function(data) {
   		$scope.oneLecturer = data;
 	});

 	lecturersSubject.success(function(data) {
   		$scope.subjects = data;
 	});
}])