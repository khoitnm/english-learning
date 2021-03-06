package tnmk.el.app.security.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tnmk.el.app.security.entity.User;

/**
 * @author khoi.tran on 1/28/17.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findOneByUsername(String username);
}
