app.factory('verification', ['$http', function($http) { 
  return $http.get('http://localhost:8080/webrest/verification/1') 
            .success(function(data) { 
              return data; 
            }) 
            .error(function(err) { 
              return err; 
            }); 
}]);