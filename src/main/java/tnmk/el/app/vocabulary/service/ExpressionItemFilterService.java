package tnmk.el.app.vocabulary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tnmk.el.app.vocabulary.entity.ExpressionItem;
import tnmk.el.app.vocabulary.model.ExpressionFilter;
import tnmk.el.app.vocabulary.repository.ExpressionItemFilterRepository;

import java.util.List;

/**
 * This class will filter suitable expressions for a user to test.
 * Suitable expressions usually have the least success correct answers or have not answered by the user yet.
 *
 * @author khoi.tran on 1/26/17.
 */
@Service
public class ExpressionItemFilterService {
    public static final int MAX_EXPRESSION_QUERY = 100;
    @Autowired
    private ExpressionItemFilterRepository expressionItemFilterRepository;

    /**
     * Filter order by count points.
     * Lesson by count points.
     *
     * @param userId
     * @param expressionFilter
     * @return
     */
    public List<ExpressionItem> filter(String userId, ExpressionFilter expressionFilter) {
        Sort sort = new Sort(Sort.Direction.ASC, "userPoints." + userId + ".latestAnswer.correctPercentage", "userPoints." + userId + ".answerDateTime");
        List<ExpressionItem> result = expressionItemFilterRepository.filter(userId, expressionFilter, false, new PageRequest(0, MAX_EXPRESSION_QUERY, sort));
        int remainItems = MAX_EXPRESSION_QUERY - result.size();
        if (remainItems > 0) {
            List<ExpressionItem> itemsWithLatestAnswers = expressionItemFilterRepository.filter(userId, expressionFilter, true, new PageRequest(0, remainItems, sort));
            result.addAll(itemsWithLatestAnswers);
        }
        return result;
    }
}
