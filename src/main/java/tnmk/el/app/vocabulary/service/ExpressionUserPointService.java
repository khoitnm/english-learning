package tnmk.el.app.vocabulary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tnmk.el.app.vocabulary.entity.ExpressionItem;
import tnmk.el.app.vocabulary.model.ExpressionItemAnswer;
import tnmk.el.app.vocabulary.repository.ExpressionItemUserPointsRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will filter suitable expressions for a user to test.
 * Suitable expressions usually have the least success correct answers or have not answered by the user yet.
 *
 * @author khoi.tran on 1/26/17.
 */
@Service
public class ExpressionUserPointService {

    @Autowired
    private ExpressionItemUserPointsRepository expressionItemUserPointsRepository;

    public List<? extends ExpressionItem> updateAnswers(String userId, List<ExpressionItemAnswer> expressionItemAnswers) {
        List<ExpressionItem> saveItems = new ArrayList<>();
        for (ExpressionItemAnswer expressionItemAnswer : expressionItemAnswers) {
            if (expressionItemAnswer.getAnswerResult() == null) {
            } else {
                expressionItemAnswer.getUserPoints().addAnswer(userId, expressionItemAnswer.getAnswerResult());
                saveItems.add(expressionItemAnswer);
            }
        }
        expressionItemUserPointsRepository.updateUserPoints(userId, saveItems);
        return expressionItemAnswers;
    }

    public int updateFavourite(String userId, ExpressionFavouriteRequest expressionFavouriteRequest) {
        return expressionItemUserPointsRepository.updateFavourite(userId, expressionFavouriteRequest.getExpressionId(), expressionFavouriteRequest.getFavourite());
    }

    public static class ExpressionFavouriteRequest {
        private String expressionId;
        private int favourite;

        public String getExpressionId() {
            return expressionId;
        }

        public void setExpressionId(String expressionId) {
            this.expressionId = expressionId;
        }

        public int getFavourite() {
            return favourite;
        }

        public void setFavourite(int favourite) {
            this.favourite = favourite;
        }
    }
}
