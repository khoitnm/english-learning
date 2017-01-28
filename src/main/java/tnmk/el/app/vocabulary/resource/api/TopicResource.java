package tnmk.el.app.vocabulary.resource.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tnmk.el.app.vocabulary.entity.Topic;

@RestController
public class TopicResource {

    @RequestMapping(value = ApiConstant.API_PREFIX + "/topics/initiation", method = RequestMethod.GET)
    public Topic init() {
        return new Topic();
    }
}