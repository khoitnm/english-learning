package tnmk.el.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import tnmk.el.MainApplication;
import tnmk.infrastructure.translate.cache.Translation;
import tnmk.infrastructure.translate.yandex.TranslationService;

/**
 * @author khoi.tran on 2/1/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
@ActiveProfiles("dev")
@WebAppConfiguration
public class TranslateServiceTest {
    @Autowired
    private TranslationService translateService;

    @Test
    public void test() {
        Translation translation = translateService.translate("en", "vi", "hello World!");
        System.out.println(translation.getTranslatedText());
    }
}
