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
        Sort sort = new Sort(Sort.Direction.ASC, "userPoints." + userId + ".answersLastFive.correctPercentage");
        return expressionItemFilterRepository.filter(userId, expressionFilter, new PageRequest(0, 100, sort));
    }
}
