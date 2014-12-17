var app = angular.module("app", [ 'ngRoute', 'ngResource' ]);
/*
app.config(function($routeProvider) {
	$routeProvider.when('/users/new', {
		controller : 'NewUserCtrl',
		templateUrl : 'views/newuser.html'
	}).when('/users/:userId', {
		controller : 'UsersByIdCtrl',
		templateUrl : 'views/userbyid.html'	
	}).when('/users', {
		controller : 'UsersCtrl',
		templateUrl : 'views/users.html'	
	}).otherwise({
		controller : 'SpaCtrl',
		templateUrl: 'views/spahome.html'
    });
});
*/