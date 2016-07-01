app.factory('lecturersSubject', ['$http', function($http) { 
  return $http.get('http://localhost:8080/webrest/subjects/by/lecturer?id=1') 
            .success(function(data) { 
              return data; 
            }) 
            .error(function(err) { 
              return err; 
            }); 
}]);