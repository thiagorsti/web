var app = angular.module('agric', ['ui.router', 'ui.bootstrap', 'ui.bootstrap.showErrors', 'ngResource']);

app.config(['$uibTooltipProvider', '$stateProvider', '$urlRouterProvider', function($uibTooltipProvider, $stateProvider, $urlRouterProvider) {
	
	$uibTooltipProvider.options({
		placement: 'top-left'
	});
	
	//$locationProvider.html5Mode(false).hashPrefix('');	
	$urlRouterProvider.otherwise('/servico/tipo');
	
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
    });
}]);
