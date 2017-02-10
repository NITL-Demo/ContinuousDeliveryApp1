'use strict';

/**
 * @ngdoc service
 * @name storeClientApp.entityService
 * @description
 * # entityService
 * Factory in the storeClientApp.
 */

angular.module('storeClientApp').factory('dataFactory', ['$http', function ($http){

	var urlBase = 'http://172.18.51.87:81/devcapsule-spring-1.0/';
	
	var dataFactory = {};

	//Find All - Valid for all entities
	dataFactory.findAll = function(entity) {
		//alert("entity:::"+urlBase + entity);
		var promise = $http({method:'GET', url: urlBase + entity})
			.then(function (data) {
				return data;
			},
			function () {
				return {'status': "Unable to get all bases"};
			});

		return promise;
	};

	//Add New - Valid for all entities
	dataFactory.addEntity = function(entity, data) {
		var promise = $http({method:'POST', url: urlBase + entity, data: data, headers: {'Content-Type': 'application/json'}})
			.then(function (data) {
				return data;
			},
			function () {
				return {'status': "Entity could not be added"};
			});

			//Entity could not be added
		return promise;
	};

	//Edit existing entity - Only in case of Pizza and Order
	dataFactory.editEntity = function(entity, id, data) {
		var promise = $http({method: 'POST', url: urlBase + entity + '/' + id, data: data,
			headers: {'Content-Type': 'application/json'}})
		    .then(function (data) {
				return data;
			},
			function () {
				return {'status': "Entity could not be edited"};
			});
		
		//Entity could not be edited
		return promise;
	};

	//Delete existing entity - Only for Orders
	dataFactory.deleteEntity = function(entity, id){
		var promise = $http({method: 'DELETE', url: urlBase + entity + '/' + id,
			headers: {'Content-Type': 'application/json'}})
		.then(function (data) {
				return data;
			},
			function () {
				return {'status': "Entity could not be deleted"};
			});
		
		//Entity could not be deleted
		
		return promise;
	};

	return dataFactory;
}]);
