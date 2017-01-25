package tnmk.el.app.vocabulary.resource.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tnmk.el.app.vocabulary.entity.LearningItem;
import tnmk.el.app.vocabulary.repository.LearningItemRepository;

import java.util.List;

@RestController
public class LearningItemResource {
    @Autowired
    private LearningItemRepository learningItemRepository;

    @RequestMapping(value = "/learning-items", method = RequestMethod.GET)
    public List<LearningItem> getHistoryEvents() {
        return learningItemRepository.findAll();
    }

    @RequestMapping(value = "/learning-items", method = RequestMethod.POST)
    public LearningItem save(@RequestBody LearningItem learningItem) {
        return learningItemRepository.save(learningItem);
    }
}