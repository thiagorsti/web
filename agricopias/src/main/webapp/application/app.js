//var app = angular.module('agric', ['ui.router', 'ui.bootstrap', 'ui.bootstrap.showErrors', 'ngResource']);
var app = angular.module('agric', ['ui.router', 'ui.bootstrap', 'ngMessages', 'ngResource', 'ngSanitize', 'angular-loading-bar', 'ngAnimate', 'bootstrap.angular.validation', 'ui.utils.masks']);

app.config(['$uibTooltipProvider', '$stateProvider', '$urlRouterProvider', 'cfpLoadingBarProvider', function($uibTooltipProvider, $stateProvider, $urlRouterProvider, cfpLoadingBarProvider) {
	
	$uibTooltipProvider.options({
		placement: 'top-left'
	});
	
//	$locationProvider.html5Mode(false).hashPrefix('');	
	$urlRouterProvider.otherwise('/cliente');
	
	$stateProvider
    // HOME STATES AND NESTED VIEWS ========================================
    .state('home', {
        url: '/home',
        templateUrl: 'partial-home.html'
    })
    
    .state('home.list', {
        url: '/list',
        templateUrl: 'partial-home-list.html',
        controller: function($scope) {
            $scope.dogs = ['Bernese', 'Husky', 'Goldendoodle'];
        }
    })

    // nested list with just some random string data
    .state('home.paragraph', {
        url: '/paragraph',
        template: 'I could sure use a drink right now.'
    })
    
    .state('tipoServico', {
    	url: '/servico/tipo',
    	templateUrl: '../servico/tipo/list.html'
    })
    
    .state('tipoServicoView', {
    	url: '/servico/tipo/view/:id',
    	templateUrl: '../servico/tipo/view.html'    	
    })
	
	.state('tipoServicoEdit', {
    	url: '/servico/tipo/edit/:id',
    	templateUrl: '../servico/tipo/edit.html'    	
    })
    
    .state('tipoServicoAdd', {
    	url: '/servico/tipo/add',
    	templateUrl: '../servico/tipo/add.html'    	
    })
	
	.state('servico', {
		url: '/servico',
		templateUrl: '../servico/list.html'
	})
	
	.state('servicoView', {
		url: '/servico/view/:id',
		templateUrl: '../servico/view.html'
	})
	
	.state('servicoEdit', {
		url: '/servico/edit/:id',
    	templateUrl: '../servico/edit.html'
	})
	
	.state('servicoAdd', {
    	url: '/servico/add',
    	templateUrl: '../servico/add.html'    	
    })
    
    .state('cliente', {
		url: '/cliente',
		templateUrl: '../cliente/list.html'
	})	
	
	.state('clienteEdit', {
		url: '/cliente/edit/:id',
    	templateUrl: '../cliente/edit.html'
	})
	
	.state('clienteAdd', {
    	url: '/cliente/add',
    	templateUrl: '../cliente/add.html'    	
    })
}])
.animation('.repeat-animate', function () {
	return {
		enter: 
			function (element, done) {				
				element.hide().show(200, function(){					
					var scope = element.scope();
					scope.$evalAsync(function(){ 
						var input = element.find('input:last')[0];
						if (input.value == '') {
							input.focus();
						}
					});
				});			
			}
	};
});
