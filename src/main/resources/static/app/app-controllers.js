angularApp.controller('angularController', ['$scope', '$http', AngularController]);
function AngularController($scope, $http) {
    this.$scope = $scope;
    $scope.globalMessage = undefined;
    if (hasValue(window.LearningItemService)) {
        $scope.learningItemService = new LearningItemService($http);
        $scope.learningItemService.controller = $scope;
        //$scope.learningItemService.init();
    }
};