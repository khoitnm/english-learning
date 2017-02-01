package tnmk.infrastructure.google.translate;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import java.io.PrintStream;

/**
 * @author khoi.tran on 2/1/17.
 */
public class GoogleTranslateService {
    public static void translateText(String sourceText, PrintStream out) {
        Translate translate = TranslateOptions.getDefaultInstance().getService();
        Translation translation = translate.translate(sourceText);

        out.printf("Source Text:\n\t%s\n", sourceText);
        out.printf("Translated Text:\n\t%s\n", translation.getTranslatedText());
    }
}
