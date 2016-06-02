app.controller('TipoServicoController', ['$scope', '$state', '$stateParams', '$uibModal', 'TipoServico', function($scope, $state, $stateParams, $uibModal, TipoServico){
	var self = this;
	
	function _goTolist() {
		$state.go('tipoServico', {}, {reload: true});
	};
	
	self.list = function() {
		self.tiposServico = TipoServico.query();
	};
	
	self.find = function() {
		self.tipoServico = TipoServico.get({ id: $stateParams.id });		
	};
	
	self.remove = function(tipoServico) {
		TipoServico.remove(tipoServico, function(){			
			_goTolist();
		});
	};
	
	self.save = function(tipoServico) {		
		if (tipoServico.id) {
			console.log(tipoServico);			
			TipoServico.update(tipoServico, function() {
				_goTolist();
			});			
		}		
	};
	
	self.newTipoServico = function() {
		self.tipoServico = {};
	};
}]);