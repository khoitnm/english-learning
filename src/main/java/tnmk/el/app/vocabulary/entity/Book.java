package tnmk.el.app.vocabulary.entity;

import org.hibernate.validator.constraints.NotBlank;
import tnmk.el.app.common.entity.BaseEntity;

import java.time.Instant;
import java.util.List;

/**
 * @author khoi.tran on 1/25/17.
 */
public class Book extends BaseEntity {
    @NotBlank
    private String name;
    private String author;

    private List<Lesson> lessons;
    private Instant publishDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Instant getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Instant publishDate) {
        this.publishDate = publishDate;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
