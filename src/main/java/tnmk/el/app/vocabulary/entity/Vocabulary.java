package tnmk.el.app.vocabulary.entity;

import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * @author khoi.tran on 1/25/17.
 */
public class Vocabulary {
    @NotBlank
    private String word;
    private List<Meaning> meanings;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }
}
