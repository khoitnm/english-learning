package tnmk.el.app.vocabulary.resource.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tnmk.el.app.common.entity.UriPrefixConstants;
import tnmk.el.app.vocabulary.entity.Lesson;
import tnmk.el.app.vocabulary.service.LessonService;

import java.util.List;

@RestController
public class LessonResource {
    @Autowired
    private LessonService lessonService;

    @RequestMapping(value = UriPrefixConstants.API_PREFIX + "/lessons", method = RequestMethod.GET)
    public List<Lesson> loadExpressionItems() {
        return lessonService.findAll();
    }

    @RequestMapping(value = UriPrefixConstants.API_PREFIX + "/lessons/{lessonId}", method = RequestMethod.GET)
    public Lesson findLesson(@PathVariable String lessonId) {
        return lessonService.findById(lessonId);
    }

    @RequestMapping(value = UriPrefixConstants.API_PREFIX + "/lessons/initiation", method = RequestMethod.GET)
    public Lesson init() {
        return new Lesson();
    }

    @RequestMapping(value = UriPrefixConstants.API_PREFIX + "/lessons", method = RequestMethod.POST)
    public Lesson save(@RequestBody Lesson lesson) {
        return lessonService.saveLesson(lesson);
    }
}