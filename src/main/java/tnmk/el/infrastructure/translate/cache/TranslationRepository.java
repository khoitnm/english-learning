package tnmk.el.infrastructure.translate.cache;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author khoi.tran on 2/1/17.
 */
@Repository
public interface TranslationRepository extends MongoRepository<Translation, String> {
    Translation findOneBySourceLanguageAndDestLanguageAndSourceText(String sourceLanguage, String destLanguage, String sourceText);
}
