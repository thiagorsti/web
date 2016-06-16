app.factory('TipoServico', ['$resource', function($resource){
	return $resource('/servico/tipos/:id', 
			{id : '@id'},
			{
				update: 
				{
					method: 'PUT'
				}
			}
	);
}]);

app.factory('Servico', ['$resource', function($resource){
	return $resource('/servicos/:id',
			{id : '@id'},
			{
				update: 
				{
					method: 'PUT'
				}
			}
	);
}]);

app.factory('EnumService', ['$resource', function($resource){	
	return $resource('/enums/:enum',
			{enum : 'enum'}, 
			{
				query: {method:'GET', isArray: true}
			}
	);
}]);