app.factory('lecturers', ['$http', function($http) { 
  return $http.get('http://localhost:8080/webrest/lecturers') 
            .success(function(data) { 
              return data; 
            }) 
            .error(function(err) { 
              return err; 
            }); 
}]);