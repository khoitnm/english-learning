package tnmk.el.app.vocabulary.entity;

import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * @author khoi.tran on 1/25/17.
 */
public class Meaning {
    private WordType wordType;
    @NotBlank
    private String explanation;
    private List<String> example;

    public WordType getWordType() {
        return wordType;
    }

    public void setWordType(WordType wordType) {
        this.wordType = wordType;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public List<String> getExample() {
        return example;
    }

    public void setExample(List<String> example) {
        this.example = example;
    }
}
