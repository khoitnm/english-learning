package tnmk.el.app.vocabulary.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tnmk.el.app.vocabulary.entity.ExpressionItem;
import tnmk.el.app.vocabulary.entity.Lesson;
import tnmk.el.app.vocabulary.entity.Topic;
import tnmk.el.app.vocabulary.repository.ExpressionItemRepository;
import tnmk.el.app.vocabulary.repository.LessonRepository;
import tnmk.el.app.vocabulary.repository.TopicRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author khoi.tran on 1/26/17.
 */
@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private ExpressionItemRepository expressionItemRepository;
    @Autowired
    private TopicRepository topicRepository;

    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    public Lesson addLesson(Lesson lesson) {
        lesson.setName(StringUtils.trim(lesson.getName()));

        Set<Topic> topics = lesson.getTopics();
        for (Topic topic : topics) {
            topic.setName(StringUtils.trim(topic.getName()));
        }
        topics = topics.stream().filter(topic -> StringUtils.isNotBlank(topic.getName())).collect(Collectors.toSet());
        lesson.setTopics(topics);
        topicRepository.save(topics);

        List<ExpressionItem> expressionItems = lesson.getExpressionItems();
        expressionItems = expressionItems.stream().filter(expressionItem -> StringUtils.isNotBlank(expressionItem.getExpression())).collect(Collectors.toList());
        lesson.setExpressionItems(expressionItems);
        expressionItemRepository.save(expressionItems);

        return lessonRepository.save(lesson);
    }

    public Lesson findById(String lessonId) {
        return lessonRepository.findOne(lessonId);
    }
}
