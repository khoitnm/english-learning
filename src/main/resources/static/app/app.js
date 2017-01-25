//'use strict';

var angularApp = angular.module('myApp', [
    //'ngSanitize',
    'ngResource',
    //'file-model',
    'ngStorage',
    'ngRoute',
    //'ui.bootstrap',
    //'ngMask'
]);
angularApp.run(function ($localStorage) {
    if (isNotBlank(window.ACCESS_TOKEN)) {
        $localStorage.token = window.ACCESS_TOKEN;
    }
});
