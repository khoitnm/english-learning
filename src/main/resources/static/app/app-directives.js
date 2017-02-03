angularApp.directive("limitTo", [function () {
    return {
        restrict: "A",
        link: function (scope, elem, attrs) {
            var limit = parseInt(attrs.limitTo);
            angular.element(elem).on("keypress", function (e) {
                if (this.value.length == limit) e.preventDefault();
            });
        }
    }
}]);
angularApp.directive('capitalize', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attrs, modelCtrl) {
            var capitalize = function (inputValue) {
                if (inputValue == undefined) inputValue = '';
                var capitalized = inputValue.toUpperCase();
                if (capitalized !== inputValue) {
                    modelCtrl.$setViewValue(capitalized);
                    modelCtrl.$render();
                }
                return capitalized;
            };
            modelCtrl.$parsers.push(capitalize);
            capitalize(scope[attrs.ngModel]); // capitalize initial value
        }
    };
});

//angularApp.directive('ngSimpleAutoComplete', function ($timeout) {
//    return {
//        require: 'ngModel',
//        link: function (scope, iElement, iAttrs, modelCtrl) {
//            iElement.autocomplete({
//                source: scope[iAttrs.uiItems],
//                select: function () {
//                    $timeout(function () {
//                        iElement.trigger('input');
//                    }, 0);
//                }
//            });
//        }
//    };
//});

/**
 * Not tested yet
 * https://codepen.io/TheLarkInn/post/angularjs-directive-labs-ngenterkey
 */
angularApp.directive('ngKeyCodePress', ngKeyCodePress);
function ngKeyCodePress() {
    return {
        restrict: 'A',
        link: function ($scope, $element, $attrs) {
            $element.bind("keypress", function (event) {
                var inputKeyCode = event.which || event.keyCode;
                var definedKeyCode = $attrs["key-code"];
                if (inputKeyCode == definedKeyCode) {
                    $scope.$apply(function () {
                        $scope.$eval(definedKeyCode, {$event: event});
                    });

                }
            });
        }
    };
}