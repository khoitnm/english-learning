package tnmk.el.infrastructure.dictionary.oxford;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tnmk.el.infrastructure.dictionary.oxford.entity.OxfordWord;

import java.util.List;

/**
 * @author khoi.tran on 2/24/17.
 */
@Repository
public interface OxfordWordRepositories extends MongoRepository<OxfordWord, String> {
    List<OxfordWord> findByLanguageAndWord(String sourceLanguage, String word);
}
