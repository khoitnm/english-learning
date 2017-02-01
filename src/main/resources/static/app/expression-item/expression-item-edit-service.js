var LessonEditService = function ($http, $q, $routeParams) {
    this.$http = $http;
    this.$q = $q;
    this.$routeParams = $routeParams;

    this.lessonInit = undefined;
    this.topicInit = undefined;
    this.expressionItemInit = undefined;
    this.meaningInit = undefined;

    this.isShowExpression = true;
    this.isShowMeaning = true;

    this.lesson = undefined;
    this.wordTypes = [
        new WordType("n", "NOUN"),
        new WordType("v", "VERB"),
        new WordType("adj", "ADJ"),
        new WordType("adv", "ADV"),
        new WordType("prep", "PREPOSITION"),
    ];
    this.lessons = [];
    this.menu = new AngularDropDowns(this.lessons);
};
LessonEditService.prototype.init = function () {
    var self = this;
    var lessonInitGet = self.$http.get(contextPath + '/api/lessons/initiation');
    var topicInitGet = self.$http.get(contextPath + '/api/topics/initiation');
    var expressionItemInitGet = self.$http.get(contextPath + '/api/expression-items/initiation');
    var meaningInitGet = self.$http.get(contextPath + '/api/expression-items/meanings/initiation');
    var lessonsGet = self.$http.get(contextPath + '/api/lessons/introductions');
    self.$q.all([lessonInitGet, topicInitGet, expressionItemInitGet, meaningInitGet, lessonsGet]).then(function (arrayOfResults) {
        self.lessonInit = arrayOfResults[0].data;
        self.topicInit = arrayOfResults[1].data;
        self.expressionItemInit = arrayOfResults[2].data;
        self.meaningInit = arrayOfResults[3].data;
        self.lessons = arrayOfResults[4].data;
        self.constructLessonsMenu(self.lessons.copyTop(20));

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
LessonEditService.prototype.constructLessonsMenu = function (lessons) {
    var self = this;
    var items = [];
    for (var i = 0; i < lessons.length; i++) {
        var lesson = lessons[i];
        var item = new AngularDropDownsItem(lesson.name, "#!/expression-item-edit?lessonId=" + lesson.id);
        items.push(item);
    }
    self.menu = new AngularDropDowns(items);
};
LessonEditService.prototype.onOffExpression = function () {
    this.isShowExpression = !this.isShowExpression;
};
LessonEditService.prototype.onOffMeaning = function () {
    this.isShowMeaning = !this.isShowMeaning;
};
LessonEditService.prototype.addTopic = function () {
    var self = this;
    self.lesson.topics.push(angular.copy(self.topicInit));
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
LessonEditService.prototype.focusExpressionItem = function (expressionItem) {
    var self = this;
    if (expressionItem.meanings.length == 0) {
        self.addExpressionMeaning(expressionItem);
    }
    self.addExpressionItemIfNecessary(expressionItem);
};
LessonEditService.prototype.addExpressionMeaningIfNecessary = function (expressionItem, meaning) {
    var self = this;
    if (hasValue(meaning.explanation)) {
        //If changing data of the last item, then add new blank item.
        var index = expressionItem.meanings.indexOf(meaning);
        if (index == expressionItem.meanings.length - 1) {
            self.addExpressionMeaning(expressionItem);
        }

        var examples = meaning.examples;
        if (examples.length == 0) {
            examples.push("");
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
    if (isNotBlank(example)) {
        //If changing data of the last item, then add new blank item.
        //var index = meaning.examples.indexOf(example);
        if ($index == meaning.examples.length - 1) {
            meaning.examples.push("");
        }
    }
};
LessonEditService.prototype.saveLesson = function () {
    var self = this;
    self.cleanLesson(self.lesson);
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
LessonEditService.prototype.cleanLesson = function (lesson) {
    var self = this;
    self.cleanTopics(lesson.topics);
    self.cleanExpressionItems(lesson.expressionItems);
};
LessonEditService.prototype.cleanTopics = function (topics) {
    for (var i = topics.length - 1; i >= 0; i--) {
        var topic = topics[i];
        if (isBlank(topic.name)) {
            topics.splice(i, 1);
        }
    }
};
LessonEditService.prototype.cleanExpressionItems = function (expressionItems) {
    var self = this;
    for (var i = expressionItems.length - 1; i >= 0; i--) {
        var expressionItem = expressionItems[i];
        self.cleanMeanings(expressionItem.meanings);
        if (isBlank(expressionItem.expression) && expressionItem.meanings.length == 0) {
            expressionItems.splice(i, 1);
        }
    }
};
LessonEditService.prototype.cleanMeanings = function (meanings) {
    var self = this;

    for (var i = meanings.length - 1; i >= 0; i--) {
        var meaning = meanings[i];
        self.cleanMeaningExamples(meaning.examples);
        if (isBlank(meaning.explanation) && meaning.examples.length == 0) {
            meanings.splice(i, 1);
        }
    }
};
LessonEditService.prototype.cleanMeaningExamples = function (examples) {
    var self = this;

    for (var i = examples.length - 1; i >= 0; i--) {
        var example = examples[i];
        if (isBlank(example)) {
            examples.splice(i, 1);
        }
    }
};
//LessonEditService.prototype.showErrorMessage = function (msg) {
//    var self = this;
//    self.infoMessage = null;
//    self.successMessage = null;
//    self.errorMessage = hasValue(msg) ? self.$sce.trustAsHtml(msg) : null;
//    console.log(msg);
//};

var WordType = function (label, value) {
    this.label = label;
    this.value = value;
};

angularApp.service('lessonEditService', ['$http', '$q', '$routeParams', LessonEditService]);
angularApp.controller('lessonEditController', ['$scope', '$http', '$q', '$routeParams', 'lessonEditService', function ($scope, $http, $q, $routeParams, lessonEditService) {
    $scope.lessonEditService = lessonEditService;
    lessonEditService.init();


}]);
