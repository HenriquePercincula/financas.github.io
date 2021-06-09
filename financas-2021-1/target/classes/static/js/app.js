var appFinancas = angular.module("appFinancas", []);

appFinancas.controller("indexController", function($scope, $http) {



	$scope.nome = "Jão";
	$scope.sobrenome = "da Silva";
	$scope.contas = [];
	$scope.conta = {};

	$scope.carregarContas = function() {
		$http({
			method: 'GET',
			url: '/contas'
		}).then(function successCallback(response) {
			$scope.contas = response.data;
			console.log("Listando todas as contas: ", $scope.contas);
		}, function errorCallback(response) {
			console.log("ERRO");
			console.log(response.status);
		});
	}

	$scope.salvarConta = function(conta) {
		$http({
			method: 'POST',
			url: '/contas',
			data: conta
		}).then(function successCallback(response) {			
			console.log("Dados salvos com sucesso.");
			$scope.carregarContas();
			$scope.cancelarEditarConta();
		}, function errorCallback(response) {
			console.log("ERRO");
			console.log(response.status);
		});
	}
	
	$scope.excluirConta = function($index) {
		//$scope.contas.splice($scope.contas[$index], 1);
		console.log($index);
		console.log($scope.contas[$index]);
		$http({
			method: 'DELETE',
			url: '/contas/'+$scope.contas[$index].id
		}).then(function successCallback(response) {			
			$scope.carregarContas();
		}, function errorCallback(response) {
			console.log("ERRO");
			console.log(response.status);
		});
	}
	
	$scope.editarConta = function(c) {
		$scope.conta = angular.copy(c);		
		$http({
			method: 'PUT',
			url: '/contas',
			data: c
		}).then(function successCallback(response) {			
			//console.log("Dados salvos com sucesso.");			
		}, function errorCallback(response) {
			console.log("ERRO");
			console.log(response.status);
		});
	
	}
	
	
	$scope.cancelarEditarConta = function() {
		$scope.conta = {};
		
	}
	
	
	$scope.carregarContas();
});
