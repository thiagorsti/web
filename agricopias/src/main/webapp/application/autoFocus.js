app.directive('autoFocus', ['$timeout', function($timeout) {
	return {
		restrict: 'A',	
        link: {
        	post: function postLink(scope, element, attr) {
        		$timeout(function() {
        			element[0].focus(); 
                }, 100);  		
        	}
        }
	}
}]);