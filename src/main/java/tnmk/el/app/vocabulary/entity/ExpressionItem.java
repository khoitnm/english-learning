package tnmk.el.app.vocabulary.entity;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import tnmk.el.app.common.entity.BaseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author khoi.tran on 1/25/17.
 */
@Document(collection = "ExpressionItem")
public class ExpressionItem extends BaseEntity {
    @Indexed
    @NotBlank
    private String expression;
    @Indexed
    private ExpressionType type;
    @Indexed
    @NotEmpty
    private List<Meaning> meanings;
    @Indexed
    private Set<String> bookIds;
    @Indexed
    private Set<String> lessonIds;
    @Indexed
    private Set<String> topicIds;

    public ExpressionItem() {
        //Every expressionItem must have at least one meaning.
        meanings = new ArrayList<>();
        meanings.add(new Meaning());
    }

    public void addLessonId(String lessonId) {
        if (this.lessonIds == null) {
            lessonIds = new HashSet<>();
        }
        if (StringUtils.isNotBlank(lessonId)) {
            lessonIds.add(lessonId);
        }
    }

    public void addBookId(String bookId) {
        if (this.bookIds == null) {
            bookIds = new HashSet<>();
        }
        if (StringUtils.isNotBlank(bookId)) {
            bookIds.add(bookId);
        }
    }

    public void addTopicId(String topicId) {
        if (this.topicIds == null) {
            this.topicIds = new HashSet<>();
        }
        if (StringUtils.isNotBlank(topicId)) {
            this.topicIds.add(topicId);
        }
    }

    public void addTopicIds(Set<String> topicIds) {
        if (this.topicIds == null) {
            this.topicIds = new HashSet<>();
        }
        Set<String> notBlankTopicIds = topicIds.stream().filter(topicId -> StringUtils.isNotBlank(topicId)).collect(Collectors.toSet());
        this.topicIds.addAll(notBlankTopicIds);
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }

    public ExpressionType getType() {
        return type;
    }

    public void setType(ExpressionType type) {
        this.type = type;
    }

    public Set<String> getBookIds() {
        return bookIds;
    }

    public void setBookIds(Set<String> bookIds) {
        this.bookIds = bookIds;
    }

    public Set<String> getLessonIds() {
        return lessonIds;
    }

    public void setLessonIds(Set<String> lessonIds) {
        this.lessonIds = lessonIds;
    }

    public Set<String> getTopicIds() {
        return topicIds;
    }

    public void setTopicIds(Set<String> topicIds) {
        this.topicIds = topicIds;
    }
}
