package tnmk.el.app.vocabulary.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import tnmk.el.app.common.entity.BaseEntity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author khoi.tran on 1/25/17.
 */
@Document(collection = "Lesson")
public class Lesson extends BaseEntity {
    @Indexed
    @NotBlank
    private String name;

    @Indexed
    @DBRef
    private Set<Topic> topics = new HashSet<>();

    @NotEmpty
    @Indexed
    @DBRef
    private List<ExpressionItem> expressionItems;

    @Indexed
    private String bookId;

    public Lesson() {
        //This list must contains at least one item.
        expressionItems = Arrays.asList(new ExpressionItem());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ExpressionItem> getExpressionItems() {
        return expressionItems;
    }

    public void setExpressionItems(List<ExpressionItem> expressionItems) {
        this.expressionItems = expressionItems;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }
}
