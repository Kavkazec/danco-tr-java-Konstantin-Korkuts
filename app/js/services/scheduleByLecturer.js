app.factory('scheduleByLecturer', ['$http', function($http) { 
var scheduleByGroupe = {
    async: function(lecturer, result) {
      var promise = $http({
          url: 'http://localhost:8080/webrest/schedules/find/by/lecturer',
          method: "GET",
          params: {
            fullName: lecturer,
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