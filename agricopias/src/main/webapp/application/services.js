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