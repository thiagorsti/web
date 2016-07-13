app.controller('EnderecoController', ['$scope', '$http', '$uibModalInstance', 'EnumService', 'EstadoService', 'CidadeService', 'endereco', function($scope, $http, $uibModalInstance, EnumService, EstadoService, CidadeService, endereco){
	var self = this;
	
	self.endereco = angular.copy(endereco);
	self.tiposEndereco = EnumService.query({enum: 'tipoEndereco'});
	EstadoService.query().$promise.then(function(estados) {
		self.estados = estados;
		console.log(self.estados);
		if (self.endereco.cidade) {
			self.uf = self.endereco.cidade.estado; 
		}		
    });
	
	self.getCidade = function(nome) {	
		var ufId = self.uf.id;
		console.log(ufId);
		console.log(nome);
		return CidadeService.query({
			ufId: ufId,
			nome: nome
		}).$promise;
	};
	
	self.submit = function() {
		var form = self.form;
		$uibModalInstance.close(self.endereco);
	};
	
	self.cancel = function() {
		$uibModalInstance.dismiss();
	};
}]);