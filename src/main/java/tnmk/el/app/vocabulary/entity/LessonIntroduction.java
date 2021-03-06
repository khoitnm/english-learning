package tnmk.el.app.vocabulary.entity;

import tnmk.el.app.common.entity.BaseEntity;

/**
 * @author khoi.tran on 1/25/17.
 */
public class LessonIntroduction extends BaseEntity {
    private String name;

    private String bookId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
