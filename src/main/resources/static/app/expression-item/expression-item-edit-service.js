var LessonEditService = function ($http, $q, $routeParams) {
    this.$http = $http;
    this.$q = $q;
    this.$routeParams = $routeParams;

    this.lessonInit = undefined;
    this.expressionItemInit = undefined;
    this.meaningInit = undefined;

    this.lesson = undefined;
    this.wordTypes = [
        new WordType("n", "NOUN"),
        new WordType("v", "VERB"),
        new WordType("adj", "ADJ"),
        new WordType("adv", "ADV"),
        new WordType("prep", "PREPOSITION"),
    ];
};
LessonEditService.prototype.init = function () {
    var self = this;
    var lessonInitGet = self.$http.get(contextPath + '/api/lessons/initiation');
    var expressionItemInitGet = self.$http.get(contextPath + '/api/expression-items/initiation');
    var meaningInitGet = self.$http.get(contextPath + '/api/expression-items/meanings/initiation');
    self.$q.all([lessonInitGet, expressionItemInitGet, meaningInitGet]).then(function (arrayOfResults) {
        self.lessonInit = arrayOfResults[0].data;
        self.expressionItemInit = arrayOfResults[1].data;
        self.meaningInit = arrayOfResults[2].data;

        var lessonId = self.$routeParams.lessonId;
        if (!hasValue(lessonId)) {
            self.lesson = angular.copy(self.lessonInit);
        } else {
            self.$http.get(contextPath + "/api/lessons/" + lessonId).then(function (successResponse) {
                self.lesson = successResponse.data;
            });
        }
    });
};
LessonEditService.prototype.addTopic = function () {
    var self = this;
    self.lesson.topics.push({});
};
LessonEditService.prototype.addExpressionItem = function () {
    var self = this;

    var expressionItem = angular.copy(self.expressionItemInit);
    self.lesson.expressionItems.push(expressionItem);
};
LessonEditService.prototype.addExpressionItemIfNecessary = function (expressionItem) {
    var self = this;
    var expression = expressionItem.expression;
    if (hasValue(expression)) {
        //If changing data of the last item, then add new blank item.
        var index = self.lesson.expressionItems.indexOf(expressionItem);
        if (index == self.lesson.expressionItems.length - 1) {
            self.addExpressionItem();
        }
    }
};
LessonEditService.prototype.addExpressionMeaning = function (expressionItem) {
    var self = this;
    var meaning = angular.copy(self.meaningInit);
    expressionItem.meanings.push(meaning);
};
LessonEditService.prototype.addExpressionMeaningIfNecessary = function (expressionItem, meaning) {
    var self = this;
    if (hasValue(meaning.explanation)) {
        //If changing data of the last item, then add new blank item.
        var index = expressionItem.meanings.indexOf(meaning);
        if (index == expressionItem.meanings.length - 1) {
            self.addExpressionMeaning(expressionItem);
        }
    }
};
LessonEditService.prototype.changeExpressionMeaning = function ($event, expressionItem, meaning) {
    var self = this;
    var explanation = meaning.explanation;

    //var dom = self.$window.currentTarget;
    //var line_height = Math.floor(dom.height() / parseInt(dom.attr("rows")));
    //var dirty_number_of_lines = Math.ceil(dom[0].scrollHeight / line_height);
    if (hasValue(explanation)) {
        meaning.explanationLinesLength = (explanation.match(/\r\n|\r|\n/g) || []).length + 1;
    }
    self.addExpressionMeaningIfNecessary(expressionItem, meaning);
};
LessonEditService.prototype.addMeaningExampleIfNecessary = function (meaning, example, $index) {
    var self = this;
    if (hasValue(example)) {
        //If changing data of the last item, then add new blank item.
        //var index = meaning.examples.indexOf(example);
        if ($index == meaning.examples.length - 1) {
            meaning.examples.push("");
        }
    }
};
LessonEditService.prototype.saveLesson = function () {
    var self = this;
    self.$http.post(contextPath + '/api/lessons', self.lesson).then(
        function (successResponse) {
            self.lesson = successResponse.data;
        }
    );
};
LessonEditService.prototype.selectWordType = function ($item) {
    var self = this;
    var meaning = this.$parent.meaning;
    var selectedWordType = meaning.wordTypeObject;
    if (hasValue(selectedWordType)) {
        meaning.wordType = selectedWordType.originalObject.value;
    } else {
        meaning.wordType = $item;
    }
    console.log(meaning.wordType);
};

LessonEditService.prototype.showErrorMessage = function (msg) {
    var self = this;
    self.infoMessage = null;
    self.successMessage = null;
    self.errorMessage = hasValue(msg) ? self.$sce.trustAsHtml(msg) : null;
    console.log(msg);
};

var WordType = function (label, value) {
    this.label = label;
    this.value = value;
};

angularApp.service('lessonEditService', ['$http', '$q', '$routeParams', LessonEditService]);
angularApp.controller('lessonEditController', ['$scope', '$http', '$q', '$routeParams', 'lessonEditService', function ($scope, $http, $q, $routeParams, lessonEditService) {
    $scope.lessonEditService = lessonEditService;
    lessonEditService.init();
}]);