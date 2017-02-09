package tnmk.el.infrastructure.dictionary;

import org.springframework.stereotype.Service;
import tnmk.el.app.vocabulary.entity.WordType;

import java.util.List;

/**
 * @author khoi.tran on 2/3/17.
 */
@Service
public class DictionaryService {

    public List<String> getExamples(String sourceLanguage, String word, WordType wordType) {
        //TODO not implement yet.
        return null;
    }
}
