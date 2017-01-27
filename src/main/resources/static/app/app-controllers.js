//angularApp.controller('angularController', ['$scope', '$http', '$q', '$window', '$routeParams', AngularController]);
//function AngularController($scope, $http, $q, $window, $routeParams) {
//    this.$scope = $scope;
//    $scope.globalMessage = undefined;
//    if (hasValue(window.LessonEditService)) {
//        $scope.lessonService = new LessonEditService($http, $q, $window, $routeParams);
//        $scope.lessonService.controller = $scope;
//    }
//    if (hasValue(window.LessonsService)) {
//        $scope.lessonsService = new LessonsService($http, $q, $window);
//        $scope.lessonsService.controller = $scope;
//    }
//};