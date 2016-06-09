app.controller('ServicoController', ['$scope', '$state', '$stateParams', '$uibModal', 'Servico', 'TipoServico', function($scope, $state, $stateParams, $uibModal, Servico, TipoServico){
	var self = this;
	
	self.criteria = '';
	
	var _goToList = function() {
		$state.go('servico', {}, {reload: true});
	};
	
	self.list = function() {
		self.servicos = Servico.query();
	};
	
	self.find = function() {
		self.servico = Servico.get({ id: $stateParams.id });		
	};
	
	self.remove = function(servico) {
		Servico.remove(servico, _goToList);
	};
	
	self.save = function() {
		$scope.$broadcast('show-errors-check-validity');
		var form = self.form;
		if (form.$invalid) {			
			console.log('Form inválido');
			return;
		}
		var servico = self.servico;
		if (servico.id) {
			console.log(servico);
			Servico.update(servico, _goToList);			
		}
		else {
			Servico.save(servico, _goToList);
		}
	};
	
	self.newServico = function() {
		self.servico = {};
		self.tiposServico = TipoServico.query();
	};
	
	self.edit = function() {
		self.find();
		self.tiposServico = TipoServico.query();
	};
}]);