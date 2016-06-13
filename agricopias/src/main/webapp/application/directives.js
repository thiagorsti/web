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


//app.directive('errorMessages', function() {
//	return {
//		restrict: "E",		
//		scope: {
//			field: "="
//		},
//		templateUrl: "errorMessages.html"
//	};
//});

app.directive('showValidation', [function() {
    return {
        restrict: 'A',
        require:'form',
        link: function(scope, element, attrs, formCtrl) {
        	element.attr('novalidate', 'novalidate');
            element.find('.form-group').each(function() {
                var $formGroup=$(this);
                var $inputs = $formGroup.find('input[ng-model],textarea[ng-model],select[ng-model]');                
                if ($inputs.length > 0) {
                    $inputs.each(function() {                    	
                        var $input=$(this);
                        var $model=formCtrl[$input.attr('name')];                        
                        scope.$watch(function() {       	
                        	return (($model.$invalid && $model.$touched) || formCtrl.$submitted);
                        }, function(isInvalid) {              	
                            $formGroup.toggleClass('has-error', isInvalid);
                        });
                    });
                }
            });
        }
    };
}]);