package tnmk.el.app.vocabulary.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tnmk.el.app.vocabulary.entity.ExpressionItem;
import tnmk.el.app.vocabulary.entity.Lesson;
import tnmk.el.app.vocabulary.entity.LessonIntroduction;
import tnmk.el.app.vocabulary.entity.Topic;
import tnmk.el.app.vocabulary.repository.ExpressionItemRepository;
import tnmk.el.app.vocabulary.repository.LessonRepository;
import tnmk.el.app.vocabulary.repository.TopicRepository;

import java.util.ArrayList;
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

    /**
     * TODO there will be some garbage expression or topics
     *
     * @param lesson
     * @return
     */
    public Lesson saveLesson(Lesson lesson) {
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

    public List<LessonIntroduction> findAllIntroductions() {
        List<Lesson> lessons = lessonRepository.findAllIntroductions();
        List<LessonIntroduction> result = new ArrayList<>();
        for (Lesson lesson : lessons) {
            LessonIntroduction lessonIntroduction = new LessonIntroduction();
            BeanUtils.copyProperties(lesson, lessonIntroduction);
            result.add(lessonIntroduction);
        }
        return result;
    }
}
