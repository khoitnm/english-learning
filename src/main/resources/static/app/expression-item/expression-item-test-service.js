var LessonTestService = function ($http, $q, $routeParams, $sce) {
    this.$http = $http;
    this.$q = $q;
    this.$routeParams = $routeParams;
    this.$sce = $sce;
    this.lessonFilter = new FilterCollection($sce, "name");
    this.topicFilter = new FilterCollection($sce, "name");
};
LessonTestService.prototype.init = function () {
    var self = this;
    var lessonIntroductionsGet = self.$http.get(contextPath + '/api/lessons/introductions');
    var topicsGet = self.$http.get(contextPath + '/api/topics');
    self.$q.all([lessonIntroductionsGet, topicsGet]).then(function (arrayOfResults) {
        var lessonIntroductions = arrayOfResults[0].data;
        var topics = arrayOfResults[1].data;

        self.lessonFilter.initByOriginalItems(lessonIntroductions);
        self.topicFilter.initByOriginalItems(topics);
    });
};


var FilterCollection = function ($sce, filterField) {
    this.$sce = $sce;
    this.filterValue = undefined;
    this.filterField = filterField;
    this.originalItems = [];
    this.filteredItems = [];
    this.selectAll = false;
    this.selectedItems = [];
};
FilterCollection.prototype.initByOriginalItems = function (originalItems) {
    this.originalItems = originalItems;
    this.filterItems();
};
FilterCollection.prototype.filterItems = function () {
    var self = this;
    self.filteredItems = [];
    if (isNotBlank(self.filterValue)) {
        for (var i = 0; i < self.originalItems.length; i++) {
            var item = self.originalItems[i];
            if (hasValue(item)) {
                var itemFieldValue = getField(item, self.filterField);
                var findResult = findMatchString(itemFieldValue, self.filterValue);
                if (findResult.matches) {
                    item.resultWithHighlightText = self.$sce.trustAsHtml(findResult.resultWithHighlightText);
                    self.filteredItems.push(item);
                } else {
                    item.resultWithHighlightText = null;
                }
            }
        }
    } else {
        this.filteredItems = self.originalItems.slice();
    }
};
FilterCollection.prototype.selectItem = function (item) {
    var self = this;
    self.originalItems.remove(item);
    self.filteredItems.remove(item);
    self.selectedItems.push(item);
};
FilterCollection.prototype.unselectItem = function (item) {
    var self = this;
    item.checked = false;
    self.originalItems.push(item);
    self.selectedItems.remove(item);
    self.filterItems();
};
angularApp.service('lessonTestService', ['$http', '$q', '$routeParams', '$sce', LessonTestService]);
angularApp.controller('lessonTestController', ['$scope', 'lessonTestService', function ($scope, lessonTestService) {
    $scope.lessonTestService = lessonTestService;
    lessonTestService.init();
}]);
