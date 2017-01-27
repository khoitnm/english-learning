package tnmk.el.app.vocabulary.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tnmk.el.app.vocabulary.entity.Lesson;

@Repository
public interface LessonRepository extends MongoRepository<Lesson, String> {
}
