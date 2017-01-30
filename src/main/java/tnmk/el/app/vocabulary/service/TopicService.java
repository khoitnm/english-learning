package tnmk.el.app.vocabulary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tnmk.el.app.vocabulary.entity.Topic;
import tnmk.el.app.vocabulary.repository.TopicRepository;

import java.util.List;

/**
 * @author khoi.tran on 1/26/17.
 */
@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

}
