package tnmk.infrastructure.texttospeech;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tnmk.common.util.IOUtil;
import tnmk.el.app.common.entity.UriPrefixConstants;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author khoi.tran on 2/2/17.
 */
@RestController
public class TextToSpeechResource {

    @RequestMapping(value = UriPrefixConstants.API_PREFIX + "/speechs", method = RequestMethod.GET)
    public void downloadSpeechFromText(@RequestParam(name = "text") String text, HttpServletResponse response) throws IOException {
        InputStream mp3InputStream = IOUtil.loadInputStreamFileInClassPath("/tmp/Button-click-sound/Button-click-sound.mp3");
//        response.addHeader("Content-disposition", "attachment;filename=Button-click-sound.MP3");//Force download file, not streaming.
        response.setContentType("audio/mpeg");
        IOUtils.copy(mp3InputStream, response.getOutputStream());
        response.flushBuffer();
    }
}
