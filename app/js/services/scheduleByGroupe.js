app.factory('scheduleByGroupe', ['$http', function($http) { 
var scheduleByGroupe = {
    async: function(groupe, result) {
      var promise = $http({
	        url: 'http://localhost:8080/webrest/schedules/find/by/groupe',
	        method: "GET",
	        params: {
	        	title: groupe,
	        	date: result
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
  return scheduleByGroupe;
}]);