var LessonService = function ($http, $q, $window) {
    this.$http = $http;
    this.$q = $q;
    this.$window = $window;
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
    //this.wordTypes = ["n", "v", "adj", "adv", "preposition"];
    this.init();
};

LessonService.prototype.init = function () {
    var self = this;
    var lessonInitGet = self.$http.get(contextPath + '/lessons/initiation');
    var expressionItemInitGet = self.$http.get(contextPath + '/expression-items/initiation');
    var meaningInitGet = self.$http.get(contextPath + '/expression-items/meanings/initiation');
    self.$q.all([lessonInitGet, expressionItemInitGet, meaningInitGet]).then(function (arrayOfResults) {
        self.lessonInit = arrayOfResults[0].data;
        self.expressionItemInit = arrayOfResults[1].data;
        self.meaningInit = arrayOfResults[2].data;
        self.lesson = angular.copy(self.lessonInit);
    });
};
LessonService.prototype.addTopic = function () {
    var self = this;
    self.lesson.topics.push({});
};
LessonService.prototype.addExpressionItem = function () {
    var self = this;

    var expressionItem = angular.copy(self.expressionItemInit);
    self.lesson.expressionItems.push(expressionItem);
};
LessonService.prototype.addExpressionItemIfNecessary = function (expressionItem) {
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
LessonService.prototype.addExpressionMeaning = function (expressionItem) {
    var self = this;
    var meaning = angular.copy(self.meaningInit);
    expressionItem.meanings.push(meaning);
};
LessonService.prototype.addExpressionMeaningIfNecessary = function (expressionItem, meaning) {
    var self = this;
    if (hasValue(meaning.explanation)) {
        //If changing data of the last item, then add new blank item.
        var index = expressionItem.meanings.indexOf(meaning);
        if (index == expressionItem.meanings.length - 1) {
            self.addExpressionMeaning(expressionItem);
        }
    }
};
LessonService.prototype.changeExpressionMeaning = function ($event, expressionItem, meaning) {
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
LessonService.prototype.saveLesson = function () {
    var self = this;
    self.$http.post(contextPath + '/lessons', self.lesson).then(
        function (successResponse) {
            self.lesson = successResponse.data;
        }
    );
};
LessonService.prototype.selectWordType = function ($item) {
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

LessonService.prototype.showErrorMessage = function (msg) {
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