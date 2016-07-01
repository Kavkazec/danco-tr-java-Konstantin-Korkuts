app.factory('student', ['$http', function($http) { 
  return $http.get('http://localhost:8080/webrest/student/1') 
            .success(function(data) { 
              return data; 
            }) 
            .error(function(err) { 
              return err; 
            }); 
}]);