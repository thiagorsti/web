app.factory('TipoServico', ['$resource', function($resource){
	return $resource('/servico/tipos/:id');
}]);

app.controller('TipoServicoController', ['$scope', '$stateParams', '$uibModal', 'TipoServico', function($scope, $stateParams, $uibModal, TipoServico){
	var self = this;
	
	self.list = function() {
		self.tiposServico = TipoServico.query();
	};
	
	self.find = function() {
		//self.tipoServico = TipoServico.get({ id: $stateParams.id })
		self.tipoServico = {};
	};
	
	self.excluir = function(param) {
		alert(param);
	};
	
	console.log($stateParams.id);
	
	self.teste = function() {
		console.log('teste');
	};
}]);