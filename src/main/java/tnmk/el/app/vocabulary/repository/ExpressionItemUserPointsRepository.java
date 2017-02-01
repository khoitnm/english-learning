package tnmk.el.app.vocabulary.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;
import tnmk.common.util.ObjectMapperUtil;
import tnmk.el.app.vocabulary.entity.ExpressionItem;
import tnmk.el.app.vocabulary.entity.UserPoint;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class ExpressionItemUserPointsRepository {
    @Autowired
    private MongoOperations mongoOperations;

    @Autowired
    private ObjectMapper objectMapper;

    public int updateUserPoints(String userId, List<ExpressionItem> expressionItems) {
        List<Pair<Query, Update>> updateOps = new ArrayList<>();
        for (ExpressionItem expressionItem : expressionItems) {
            Query query = new Query().addCriteria(where("_id").is(new ObjectId(expressionItem.getId())));
            UserPoint userPoint = expressionItem.getUserPoints().getUserPoint(userId);
            DBObject dbObject = convertObjectToDBObject(userPoint);
            Update update = Update.update("userPoints." + userId, dbObject);
            Pair<Query, Update> pair = Pair.of(query, update);
            updateOps.add(pair);
        }

        return mongoOperations.bulkOps(BulkOperations.BulkMode.ORDERED, ExpressionItem.class, ExpressionItem.class.getAnnotation(Document.class).collection()).updateOne(updateOps).execute().getModifiedCount();

    }

    private DBObject convertObjectToDBObject(Object object) {
        String json = ObjectMapperUtil.toJson(objectMapper, object);
        return BasicDBObject.parse(json);
    }
}
