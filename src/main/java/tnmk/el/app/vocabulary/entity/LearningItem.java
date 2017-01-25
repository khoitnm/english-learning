package tnmk.el.app.vocabulary.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

/**
 * @author khoi.tran on 1/25/17.
 */
@Document(collection = "LearningItem")
public class LearningItem {
    @Indexed
    @NotBlank
    private String expression;
    @Indexed
    private LearningItemType type;
    @Indexed
    private List<Meaning> meanings;
    @Indexed
    private Set<String> bookIds;
    @Indexed
    private Set<String> lessonIds;
    @Indexed
    private Set<String> topicIds;

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

    public LearningItemType getType() {
        return type;
    }

    public void setType(LearningItemType type) {
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
