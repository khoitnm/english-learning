(function () {
    'use strict';
    var angularApp = angular.module('angularApp', [
        //'ngSanitize',
        'ngResource'
        //'file-model',
        //'ngStorage',
        //'ngRoute',
        //'ui.bootstrap',
        //'ngMask'
    ]);

    function PageController($scope, $http, $sce) {
        this.$scope = $scope;
        $scope.globalMessage = undefined;
        if (hasValue(window.PageService)) {
            document.pageService = new PageService($scope, $http, $sce);
            $scope.service = document.pageService;
            document.pageService.init();
        }
    };

    angularApp.controller('pageController', ['$scope', '$http', '$sce', PageController]);

    //app.config(routeConfig);

    //app.run(runFn);

    //function routeConfig($routeProvider) {
    //    $routeProvider
    //        .when('/', {
    //            templateUrl: '../app/contents/header.html',
    //            controller: 'LoginController'
    //        })
    //        .when('/home', {
    //            templateUrl: 'app/templates/home.html',
    //            controller: 'DashboardController',
    //            activeTab: 'home'
    //        })
    //        .when('/blacklist', {
    //            templateUrl: 'app/templates/blacklist.html',
    //            controller: 'BlackListController',
    //            activeTab: 'blacklist'
    //        })
    //        .when('/collection-file', {
    //            templateUrl: 'app/templates/collection-file.html',
    //            controller: 'CollectionFileController',
    //            activeTab: 'collection-file'
    //        })
    //        .when('/policy-detail', {
    //            templateUrl: 'app/templates/policy-detail.html',
    //            controller: 'PolicyDetailController',
    //            activeTab: 'policy-detail'
    //        })
    //        .when('/configuration', {
    //            templateUrl: 'app/templates/configuration.html',
    //            controller: 'ConfigurationController',
    //            activeTab: 'configuration'
    //        })
    //        .when('/total-quote-count', {
    //            templateUrl: 'app/templates/total-quote-count.html',
    //            controller: 'TotalQuoteCountController',
    //            activeTab: 'total-quote-count'
    //        })
    //        .when('/commission', {
    //            templateUrl: 'app/templates/commission.html',
    //            controller: 'CommissionController',
    //            activeTab: 'commission'
    //        })
    //        .when('/commission-result', {
    //            templateUrl: 'app/templates/commission-result.html',
    //            controller: 'CommissionResultController',
    //            activeTab: 'commission-result'
    //        })
    //        .otherwise({
    //            redirectTo: '/home'
    //        });
    //
    //}

    //function runFn($rootScope, $location, $templateCache, AuthService) {
    //    $rootScope.$on('$routeChangeStart', routeChangeStart);
    //
    //    function routeChangeStart(event, next, current) {
    //
    //        // Remove template caching to accept server side rules ->
    //        $templateCache.remove('app/templates/partials/sidebar.html');
    //        $templateCache.remove('app/templates/home.html');
    //        // Remove template caching to accept server side rules <-
    //
    //        if (!AuthService.isAuthenticated()) {
    //            // User is not logged in
    //            console.log('User not logged in');
    //            $rootScope.errorMsg = 'Session expired. Please login again.';
    //            $location.path('/');
    //            setTimeout(function () {
    //                $rootScope.$apply(function () {
    //                    $rootScope.errorMsg = null;
    //                });
    //            }, 4000);
    //        }
    //    }
    //}

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
}());