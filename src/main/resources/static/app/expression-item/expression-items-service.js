var LessonsService = function ($http, $q) {
    this.$http = $http;
    this.$q = $q;

    //this.wordTypes = ["n", "v", "adj", "adv", "preposition"];
    this.init();
};

LessonsService.prototype.init = function () {
    var self = this;
    var lessonsGet = self.$http.get(contextPath + '/api/lessons/introductions');
    self.$q.all([lessonsGet]).then(function (arrayOfResults) {
        self.lessons = arrayOfResults[0].data;
    });
};

angularApp.service('lessonsService', ['$http', '$q', '$routeParams', LessonsService]);
angularApp.controller('lessonsController', ['$scope', '$http', '$q', '$routeParams', 'lessonsService', function ($scope, $http, $q, $routeParams, lessonsService) {
    $scope.lessonsService = lessonsService;
}]);
