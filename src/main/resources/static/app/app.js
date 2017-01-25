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
    if (isNotBlank(ACCESS_TOKEN)) {
        $localStorage.token = ACCESS_TOKEN;
    }
});
