app.factory('lecturer', ['$http', function($http) { 
  return $http.get('http://localhost:8080/webrest/lecturer/1') 
            .success(function(data) { 
              return data; 
            }) 
            .error(function(err) { 
              return err; 
            }); 
}]);