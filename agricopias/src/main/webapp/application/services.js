app.factory('Cliente', ['$resource', function($resource){
	return $resource('/clientes/:id',
			{id: '@id'},
			{
				update: 
				{
					method: 'PUT'
				}
			}
	);
}])

.factory('Servico', ['$resource', function($resource){
	return $resource('/servicos/:id',
			{id: '@id'},
			{
				update: 
				{
					method: 'PUT'
				}
			}
	);
}])

.factory('TipoServico', ['$resource', function($resource){
	return $resource('/servico/tipos/:id', 
			{id: '@id'},
			{
				update: 
				{
					method: 'PUT'
				}
			}
	);
}])

.factory('EnumService', ['$resource', function($resource){	
	return $resource('/enums/:enum',
			{enum : 'enum'}, 
			{
				query: {method: 'GET', isArray: true}
			}
	);
}])

.factory('EstadoService', ['$resource', function($resource){
	return $resource('/estados/:id',
			{id: '@id'}
	);
}])

.factory('CidadeService', ['$resource', function($resource){
	return $resource('/cidades/:id',
			{id: '@id'}
	);
}]);
