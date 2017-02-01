package tnmk.el.app.vocabulary.model;

import tnmk.el.app.vocabulary.entity.ExpressionItem;

/**
 * @author khoi.tran on 1/31/17.
 */
public class ExpressionItemAnswer extends ExpressionItem {
    /**
     * This value can be either 1 or -1.
     */
    private Integer answerResult;

    public Integer getAnswerResult() {
        return answerResult;
    }

    public void setAnswerResult(Integer answerResult) {
        this.answerResult = answerResult;
    }
}
