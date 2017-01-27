package tnmk.el.app.vocabulary.resource.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tnmk.el.app.vocabulary.entity.ExpressionItem;
import tnmk.el.app.vocabulary.entity.Meaning;
import tnmk.el.app.vocabulary.repository.ExpressionItemRepository;

import java.util.List;

@RestController
public class ExpressionItemResource {
    @Autowired
    private ExpressionItemRepository expressionItemRepository;

    @RequestMapping(value = "/expression-items/initiation", method = RequestMethod.GET)
    public ExpressionItem initExpressionItem() {
        return new ExpressionItem();
    }

    @RequestMapping(value = "/expression-items/meanings/initiation", method = RequestMethod.GET)
    public Meaning initMeaning() {
        return new Meaning();
    }

    @RequestMapping(value = "/expression-items", method = RequestMethod.GET)
    public List<ExpressionItem> loadExpressionItems() {
        return expressionItemRepository.findAll();
    }

    @RequestMapping(value = "/expression-items", method = RequestMethod.POST)
    public ExpressionItem save(@RequestBody ExpressionItem learningItem) {
        return expressionItemRepository.save(learningItem);
    }
}