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


app.directive('ngConfirm',['$uibModal', function ($uibModal) {
    return {
        restrict: 'A',
        scope: {
            ngConfirmMessage: '@',
            ngConfirm: '&'
        },
        link: function (scope, element) {
            element.bind('click', function () {
                    var modalInstance = $uibModal.open({
                    	template: '<div class="modal-header"><h3 class="modal-title">{{confirmMessage}}</h3></div><div class="modal-footer"><button class="btn btn-primary" type="button" ng-click="ok()">OK</button><button class="btn btn-warning" type="button" ng-click="cancel()" auto-focus>Cancelar</button></div>',
                        controller: 'ModalConfirmCtrl',
                        size: 'sm',
                        windowClass: 'confirm-window',
                        resolve: {
                            confirmClick: function () {
                                return scope.ngConfirm;
                            },
                            confirmMessge: function () {
                                return scope.ngConfirmMessage;
                            }
                        }
                    });
            });
        }
    }
}])
.controller('ModalConfirmCtrl', ['$scope', '$uibModalInstance', 'confirmClick', 'confirmMessge',
    function ($scope, $uibModalInstance, confirmClick, confirmMessge) {
        $scope.confirmMessage = confirmMessge;
        function closeModal() {
            $uibModalInstance.dismiss('cancel');
        }
 
        $scope.ok = function () {
            confirmClick();
            closeModal();
        }
 
        $scope.cancel = function () {
            closeModal();
        }
	}
]);


app.directive('errorMessages', function() {
	return {
		restrict: "E",
		scope: {
			field: "="
		},
		templateUrl: "errorMessages.html"
	};
});

app.directive('showValidation', ['$timeout', '$compile', function($timeout, $compile) {
    return {
        restrict: 'A',
        require:'form',        
        link: function(scope, element, attrs, formCtrl) {
        	element.attr('novalidate', 'novalidate');
        	var inputPattern = 'input[ng-model],textarea[ng-model],select[ng-model]';
        	element.on('submit', function() {
        		$timeout(function() {
        			if (formCtrl.$invalid) {
        				var $input = element.find('.form-group ' + inputPattern).filter('.ng-invalid').filter(':visible').first();
        				$input.focus();
        			}
        		});
            });
            element.find('.form-group').each(function() {
                var $formGroup=$(this);
                var $inputs = $formGroup.find(inputPattern);
                if ($inputs.length > 0) {
                	var $formName = formCtrl.$name;
                    $inputs.each(function() {                    	
                        var $input=$(this);
                        var $model=formCtrl[$input.attr('name')];
                        var $elems = $formGroup.find('error-messages');                        
                        if ($elems.size() == 0) {                        	
                        	var $field = $formName + '.' + $model.$name
                        	var $messages = '<error-messages field="' + $field + '"></error-messages>';
                        	var el = $compile($messages)(scope);
                        	$formGroup.append(el);          	
                        }
                        scope.$watch(function() {
                        	return ($model.$invalid && ($model.$touched || formCtrl.$submitted));
                        }, function(isInvalid) {
                        	console.log($input.attr('name'));
                            $formGroup.toggleClass('has-error', isInvalid);
                        });
                    });
                }
            });
        }
    };
}]);