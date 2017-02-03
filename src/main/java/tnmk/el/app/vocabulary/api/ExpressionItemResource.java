package tnmk.el.app.vocabulary.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tnmk.el.app.common.entity.UriPrefixConstants;
import tnmk.el.app.security.entity.User;
import tnmk.el.app.security.helper.SecurityContextHelper;
import tnmk.el.app.vocabulary.entity.ExpressionItem;
import tnmk.el.app.vocabulary.entity.Meaning;
import tnmk.el.app.vocabulary.model.ExpressionFilter;
import tnmk.el.app.vocabulary.model.ExpressionItemAnswer;
import tnmk.el.app.vocabulary.repository.ExpressionItemRepository;
import tnmk.el.app.vocabulary.service.ExpressionItemFilterService;
import tnmk.el.app.vocabulary.service.ExpressionUserPointService;

import java.util.List;

@RestController
public class ExpressionItemResource {
    @Autowired
    private ExpressionItemFilterService expressionItemFilterService;
    @Autowired
    private ExpressionUserPointService expressionUserPointService;

    @Autowired
    private ExpressionItemRepository expressionItemRepository;

    @RequestMapping(value = UriPrefixConstants.API_PREFIX + "/expression-items/initiation", method = RequestMethod.GET)
    public ExpressionItem initExpressionItem() {
        return new ExpressionItem();
    }

    @RequestMapping(value = UriPrefixConstants.API_PREFIX + "/expression-items/meanings/initiation", method = RequestMethod.GET)
    public Meaning initMeaning() {
        return new Meaning();
    }

    @RequestMapping(value = UriPrefixConstants.API_PREFIX + "/expression-items", method = RequestMethod.GET)
    public List<ExpressionItem> loadExpressionItems() {
        return expressionItemRepository.findAll();
    }

    @RequestMapping(value = UriPrefixConstants.API_PREFIX + "/expression-items/answers", method = RequestMethod.POST)
    public List<? extends ExpressionItem> updateAnswers(@RequestBody List<ExpressionItemAnswer> expressionItemAnswers) {
        User user = SecurityContextHelper.validateExistAuthenticatedUser();
        return expressionUserPointService.updateAnswers(user.getId(), expressionItemAnswers);
    }

    @RequestMapping(value = UriPrefixConstants.API_PREFIX + "/expression-items/favourite", method = RequestMethod.POST)
    public int updateFavourite(@RequestBody ExpressionUserPointService.ExpressionFavouriteRequest expressionFavouriteRequest) {
        User user = SecurityContextHelper.validateExistAuthenticatedUser();
        return expressionUserPointService.updateFavourite(user.getId(), expressionFavouriteRequest);
    }

    @RequestMapping(value = UriPrefixConstants.API_PREFIX + "/expression-items/filter", method = RequestMethod.POST)
    public List<ExpressionItem> filterExpressionItems(@RequestBody ExpressionFilter expressionFilter) {
        User user = SecurityContextHelper.validateExistAuthenticatedUser();
        return expressionItemFilterService.filter(user.getId(), expressionFilter);
    }

}