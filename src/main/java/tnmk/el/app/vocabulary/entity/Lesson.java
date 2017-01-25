package tnmk.el.app.vocabulary.entity;

import org.hibernate.validator.constraints.NotBlank;
import tnmk.el.app.common.entity.BaseEntity;

import java.util.List;

/**
 * @author khoi.tran on 1/25/17.
 */
public class Lesson extends BaseEntity {
    @NotBlank
    private String name;

    private List<Vocabulary> words;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vocabulary> getWords() {
        return words;
    }

    public void setWords(List<Vocabulary> words) {
        this.words = words;
    }
}
