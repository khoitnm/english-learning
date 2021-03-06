package tnmk.el.infrastructure.tts.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tnmk.el.infrastructure.filestorage.entity.FileItem;
import tnmk.el.infrastructure.filestorage.entity.FileItemService;

/**
 * @author khoi.tran on 2/2/17.
 */
@Service
public class TtsItemService {
    private static final String MIMETYPE_MP3 = "audio/mpeg";
    @Autowired
    private FileItemService fileItemService;

    @Autowired
    private TtsItemRepository ttsItemRepository;

    public TtsItem findText(String sourceLanguage, String originalText) {
        String text = cleanupText(originalText);
        return ttsItemRepository.findOneByLocaleAndText(sourceLanguage, text);
    }

    public String cleanupText(String originalText) {
        return originalText.trim().toLowerCase();
    }

    public TtsItem putText(String sourceLanguage, String originalText, byte[] mp3Data) {
        String text = cleanupText(originalText);
        TtsItem ttsItem = findText(sourceLanguage, text);
        if (ttsItem == null) {
            ttsItem = new TtsItem();
        }

        FileItem oldFileItem = ttsItem.getFileItem();
        if (oldFileItem != null) {
            fileItemService.remove(oldFileItem.getId());
        }

        FileItem newFileItem = fileItemService.save(text + "_" + sourceLanguage + ".mp3", MIMETYPE_MP3, mp3Data);
        ttsItem.setFileItem(newFileItem);
        ttsItem.setText(text);
        ttsItem.setLocale(sourceLanguage);
        return ttsItemRepository.save(ttsItem);
    }
}
