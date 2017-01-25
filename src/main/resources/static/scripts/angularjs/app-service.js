function AppService() {
}
var appService = new AppService();

AppService.prototype.logout = function () {
    var logoutForm = $("#logoutForm");
    logoutForm.submit();
};
AppService.prototype.pageSetup = function (contextPath) {
    this.contextPath = contextPath;
    this.ajaxSetup();
    //$('.date-picker').datepicker();
    //if (hasValue(document.pageService)) {
    //    document.pageService.init();
    //}
};
/**
 * function getCSRF
 * @returns an object value with following structures:
 * {
 * 	csrfHeaderName: the name which will be used to set to header for sending csrf token to server,
 *	csrfToken: the value of csrf token
 * }
 */
AppService.prototype.getCSRF = function () {
    var result = {
        csrfHeaderName: undefined,
        csrfToken: undefined
    };
    result.csrfHeaderName = $("meta[name='_csrf_header']").attr("content");
    result.csrfToken = $("meta[name='_csrf']").attr("content");
    return result;
};
AppService.prototype.getCsrfHeader = function () {
    var result = {};
    var csrf = this.getCSRF();
    result[csrf.csrfHeaderName] = csrf.csrfToken;
    return result;
}
AppService.prototype.ajaxSetup = function () {
    var csrf = this.getCSRF();
    var csrfHeader = {};
    csrfHeader[csrf.csrfHeaderName] = csrf.csrfToken;

    //Setup ajax for jQuery
    $.ajaxSetup({
        headers: csrfHeader
    });


};
