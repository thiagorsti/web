app.factory('bsProcessValidator', function($timeout) {
	return function(scope, element, ngClass, bsClass) {
		$timeout(function() {
	        var input = element.find('input');
	        if(!input.length) { input = element.find('select'); }
	        if(!input.length) { input = element.find('textarea'); }
	        if (input.length) {
	        	scope.$watch(function() {
	        		return input.hasClass(ngClass) && input.hasClass('ng-dirty');
	        	}, function(isValid) {
	        		element.toggleClass(bsClass, isValid);
	        	});
	        }
		});
	};
});

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