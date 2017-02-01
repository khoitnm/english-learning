angularApp.factory('errorHttpInterceptor', ['$q', '$rootScope', function ($q, $rootScope) {
    return {
        // optional method
        response: function (response) {
            //if (response.status == 200) {
            //    $rootScope.globalMessage = "Success";
            //} else {
            //    $rootScope.globalMessage = undefined;
            //}
            $rootScope.userMessage = undefined;
            $rootScope.globalMessage = undefined;
            return response;
        },
        responseError: function responseError(rejection) {
            //TODO Maybe 403 is for authorization only. For Session expired, only need to check 401 status.
            if (rejection.status == 403) {
                //It does not throw you to the login page immediately because you may need to capture some progressing input data.
                $rootScope.globalMessage = "Your session is expired! Please login again.";
            } else if (rejection.status == 401) {
                $rootScope.globalMessage = "Your session is expired. Please login again!";
            } else if (rejection.status == 500) {
                $rootScope.userMessage = rejection.data.userMessage;
            } else {
                $rootScope.globalMessage = rejection.data.userMessage;
            }
            return $q.reject(rejection);
        }
    };
}]);

angularApp.config(['$httpProvider', function ($httpProvider) {
    $httpProvider.interceptors.push('errorHttpInterceptor');
}]);

angular.module('exceptionOverwrite', []).factory('$exceptionHandler', ['$rootScope', function ($rootScope) {
    return function myExceptionHandler(exception, cause) {
        $rootScope.globalMessage = exception;
    };
}]);