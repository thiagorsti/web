app.directive('errorMessages', function() {
	return {
		restrict: "E",		
		scope: {
			field: "="
		},
		templateUrl: "errorMessages.html"
	};
});