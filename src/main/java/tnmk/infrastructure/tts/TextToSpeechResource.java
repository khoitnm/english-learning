package tnmk.infrastructure.tts;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tnmk.el.app.common.entity.UriPrefixConstants;
import tnmk.infrastructure.filestorage.entity.FileItem;
import tnmk.infrastructure.tts.cache.TtsItem;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author khoi.tran on 2/2/17.
 */
@RestController
public class TextToSpeechResource {
    @Autowired
    private TextToSpeechService textToSpeechService;

    /**
     * @param text
     * @param locale   view more at http://www.voicerss.org/api/documentation.aspx
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = UriPrefixConstants.API_PREFIX + "/tts", method = RequestMethod.GET)
    public void downloadSpeechFromText(@RequestParam(name = "text", required = true) String text, @RequestParam(name = "locale", defaultValue = "en-us") String locale, HttpServletResponse response) throws IOException {
        TtsItem ttsItem = textToSpeechService.toSpeech(locale, text);
        FileItem fileItem = ttsItem.getFileItem();
//        InputStream mp3InputStream = IOUtil.loadInputStreamFileInClassPath("/tmp/Button-click-sound/Button-click-sound.mp3");
//        response.addHeader("Content-disposition", "attachment;filename=Button-click-sound.MP3");//Force download file, not streaming.
//        byte[] data = IOUtil.loadBinaryFileInClassPath("/tmp/Button-click-sound/Button-click-sound.mp3");

        response.setContentType(fileItem.getMimeType());
        byte[] mp3Data = fileItem.getBytesContent();
        IOUtils.write(mp3Data, response.getOutputStream());
        response.flushBuffer();
    }
}
