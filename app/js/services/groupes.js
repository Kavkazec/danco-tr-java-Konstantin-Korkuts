app.factory('groupes', ['$http', function($http) { 
  return $http.get('http://localhost:8080/webrest/groupes') 
            .success(function(data) { 
              return data; 
            }) 
            .error(function(err) { 
              return err; 
            }); 
}]);