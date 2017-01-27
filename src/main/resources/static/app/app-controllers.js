angularApp.controller('angularController', ['$scope', '$http', '$q', '$window', AngularController]);
function AngularController($scope, $http, $q, $window) {
    this.$scope = $scope;
    $scope.globalMessage = undefined;
    if (hasValue(window.LessonService)) {
        $scope.lessonService = new LessonService($http, $q, $window);
        $scope.lessonService.controller = $scope;
        //$scope.learningItemService.init();
    }
};