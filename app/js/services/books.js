app.factory('books', ['$http', function($http) { 
  return $http.get('http://localhost:8080/webrest/books') 
            .success(function(data) { 
              return data; 
            }) 
            .error(function(err) { 
              return err; 
            }); 
}]);