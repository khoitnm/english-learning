package tnmk.el.app.vocabulary.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import tnmk.el.app.vocabulary.entity.ExpressionItem;
import tnmk.el.app.vocabulary.model.ExpressionFilter;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class ExpressionItemFilterRepository {
    @Autowired
    private MongoOperations mongoOperations;

    public List<ExpressionItem> filter(String userId, ExpressionFilter expressionFilter, boolean hasLatestAnswers, Pageable pageable) {
        Query query = createQuery(userId, expressionFilter, hasLatestAnswers);
        limitFields(userId, query);
        List<ExpressionItem> result = executeQuery(query, ExpressionItem.class, pageable);
        return result;
    }

    private <T> List<T> executeQuery(Query query, Class<T> elementClass, Pageable pageable) {
        List<T> result = mongoOperations.find(query.with(pageable), elementClass, elementClass.getAnnotation(Document.class).collection());
        return result;
    }

    private void limitFields(String userId, Query query) {
        query.fields()
//                .exclude("bookIds")
//                .exclude("lessonIds")
//                .exclude("topicIds")
//                .exclude("userPoints")

                .include("expression")
                .include("type")
                .include("expression")
                .include("meanings")
                .include("userPoints." + userId)
        ;
    }

    private Query createQuery(String userId, ExpressionFilter expressionFilter, boolean hasLatestAnswers) {
        Query query = new Query();
        if (!expressionFilter.isSelectAllBooks()) {
            if (expressionFilter.getSelectedBookIds() != null && !expressionFilter.getSelectedBookIds().isEmpty()) {
                query.addCriteria(where("bookIds").in(expressionFilter.getSelectedBookIds()));
            }
        }
        if (!expressionFilter.isSelectAllLessons()) {
            if (expressionFilter.getSelectedLessonIds() != null && !expressionFilter.getSelectedLessonIds().isEmpty()) {
                query.addCriteria(where("lessonIds").in(expressionFilter.getSelectedLessonIds()));
            }
        }
        if (!expressionFilter.isSelectAllTopics()) {
            if (expressionFilter.getSelectedTopicIds() != null && !expressionFilter.getSelectedTopicIds().isEmpty()) {
                query.addCriteria(where("topicIds").in(expressionFilter.getSelectedTopicIds()));
            }
        }
        query.addCriteria(where("userPoints." + userId + ".latestAnswers").exists(hasLatestAnswers));
//        query.addCriteria(
//                where("")
//                        .orOperator(
//                                where("userPoints").exists(false)
//                                , where("userPoints." + userId).exists(false)
//                                , where("userPoints." + userId + ".answersLastFive.correctPercentage").lt(0.3)
//                        )
//        );
        return query;
    }
}