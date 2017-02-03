package tnmk.el.app.vocabulary.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tnmk.el.app.vocabulary.entity.Topic;

@Repository
public interface TopicRepository extends MongoRepository<Topic, String> {
    Topic findOneByName(String name);
}
