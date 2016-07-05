app.controller('EnderecoController', ['$scope', '$http', '$uibModalInstance', 'EnumService', 'EstadoService', 'endereco', function($scope, $http, $uibModalInstance, EnumService, EstadoService, endereco){
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
	
	self.getCidade = function(val) {
		return $http.get('//maps.googleapis.com/maps/api/geocode/json', {
			params: {
				address: val,
				sensor: false
			}
	    }).then(function(response){
	    	console.log(response);
	      return response.data.results.map(function(item){
	        return item.formatted_address;
	      });
	    });
	};
	
	self.submit = function() {
		var form = self.form;
		$uibModalInstance.close(self.endereco);
	};
	
	self.cancel = function() {
		$uibModalInstance.dismiss();
	};
}]);