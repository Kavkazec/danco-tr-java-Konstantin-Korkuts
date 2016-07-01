app.factory('authorization', ['$http', function($http) { 
var authorization = {
    async: function(name, pass) {
      var promise = $http({
	        url: 'http://localhost:8080/webrest/users/find',
	        method: "GET",
	        params: {
	        	login: name,
	        	password: pass
	        }
	    }).success(function(data) { 
              return data;
            }) 
            .error(function(err) { 
              return err; 
        	}); 
      return promise;
    }
  };
  return authorization;
}]);