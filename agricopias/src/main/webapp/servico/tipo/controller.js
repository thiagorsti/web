app.controller('TipoServicoController', ['$scope', '$state', '$stateParams', '$uibModal', 'TipoServico', function($scope, $state, $stateParams, $uibModal, TipoServico){
	var self = this;
	
	self.criteria = '';
	
	var _goToList = function() {
		$state.go('tipoServico', {}, {reload: true});
	};
	
	self.list = function() {
		self.tiposServico = TipoServico.query();
	};
	
	self.find = function() {
		self.tipoServico = TipoServico.get({ id: $stateParams.id });		
	};
	
	self.remove = function(tipoServico) {
		TipoServico.remove(tipoServico, _goToList);
	};
	
	self.teste = function() {
		alert('ok');
	};
	
	self.save = function() {
		$scope.$broadcast('show-errors-check-validity');
		var form = self.form;
		if (form.$invalid) {			
			console.log('Form inválido');
			return;
		}
		var tipoServico = self.tipoServico;
		if (tipoServico.id) {
			console.log(tipoServico);
			TipoServico.update(tipoServico, _goToList);			
		}
		else {
			TipoServico.save(tipoServico, _goToList);
		}
	};
	
	self.newTipoServico = function() {
		self.tipoServico = {};
	};
}]);