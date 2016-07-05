app.controller('ClienteController', ['$scope', '$state', '$stateParams', '$uibModal', 'Cliente', 'EnumService', function($scope, $state, $stateParams, $uibModal, Cliente, EnumService){
	var self = this;
	
	self.criteria = '';
	
	var _loadData = function() {
		self.tiposPessoa = EnumService.query({enum: 'tipoPessoa'});				
	};
	
	var _goToList = function() {
		$state.go('cliente', {}, {reload: true});
	};
	
	self.list = function() {
		self.clientes = Cliente.query();
	};
	
	self.find = function() {
		//self.cliente = Cliente.get({ id: $stateParams.id });
		Cliente.get({ id: $stateParams.id }).$promise.then(function(cliente) {
		      self.cliente = cliente;
		      self.showEnderecoForm(0);
	    });		
	};
	
	self.remove = function(cliente) {
		Cliente.remove(cliente, _goToList);
	};
	
	self.save = function() {		
		var form = self.form;
		if (form.$invalid) {			
			console.log('Form inválido');
			return;
		}		
		var cliente = self.cliente;
		if (cliente.id) {			
			Cliente.update(cliente, _goToList);			
		}
		else {
			Cliente.save(cliente, _goToList);
		}
	};
	
	self.newCliente = function() {
		self.cliente = {};
		_loadData();
	};
	
	self.edit = function() {
		self.find();
		_loadData();		
	};
	
	self.addEmail = function() {
		if (!self.cliente.emails) {
			self.cliente.emails = [];
		}		
		self.cliente.emails.push('');		
	};
	
	self.removeEmail = function(index) {
		self.cliente.emails.splice(index, 1);
	};
	
	self.addTelefone = function() {
		if (!self.cliente.telefones) {
			self.cliente.telefones = [];
		}
		self.cliente.telefones.push('');
	};
	
	self.removeTelefone = function(index) {
		self.cliente.telefones.splice(index, 1);
	};
	
	self.addEndereco = function() {
		if (!self.cliente.enderecos) {
			self.cliente.enderecos = [];
		}
		self.cliente.enderecos.push({});
	};
	
	self.removeEndereco = function(index) {
		self.cliente.enderecos.splice(index, 1);
	};	
	
	self.showEnderecoForm = function($index) {
		var endereco = {};
		if ($index >= 0) {
			endereco = self.cliente.enderecos[$index];
		}
		$uibModal.open({
			templateUrl: "/endereco/_form.html",
			controller: "EnderecoController",
			controllerAs: "endCtrl",
			resolve: {
				endereco: function() {
					return endereco;
				}
			}
		}).result.then(function(editedEndereco){			
			if ($index >= 0) {
				self.cliente.enderecos[$index] = editedEndereco;
			}
			else {
				self.cliente.enderecos.push(editedEndereco);
			}			
		});
	};	
}]);