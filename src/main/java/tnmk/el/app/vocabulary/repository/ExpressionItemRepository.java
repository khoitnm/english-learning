package tnmk.el.app.vocabulary.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tnmk.el.app.vocabulary.entity.ExpressionItem;

import java.util.List;

@Repository
public interface ExpressionItemRepository extends MongoRepository<ExpressionItem, String> {
    List<ExpressionItem> findByLessonIdsIn(String lessonId, Sort sort);
}
