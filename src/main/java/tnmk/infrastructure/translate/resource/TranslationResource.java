package tnmk.infrastructure.translate.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tnmk.el.app.common.entity.UriPrefixConstants;
import tnmk.infrastructure.translate.cache.Translation;
import tnmk.infrastructure.translate.yandex.TranslationService;

/**
 * @author khoi.tran on 2/1/17.
 */
@RestController
public class TranslationResource {
    @Autowired
    private TranslationService translateService;

    @RequestMapping(value = UriPrefixConstants.API_PREFIX + "/translations", method = RequestMethod.POST)
    public Translation translate(@RequestBody Translation translation) {
        return translateService.translate(
                translation.getSourceLanguage()
                , translation.getDestLanguage()
                , translation.getSourceText()
        );
    }

}
