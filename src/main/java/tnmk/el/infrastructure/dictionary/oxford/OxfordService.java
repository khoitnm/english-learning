package tnmk.el.infrastructure.dictionary.oxford;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import tnmk.common.exception.UnexpectedException;
import tnmk.el.infrastructure.dictionary.oxford.entity.OxfordResponse;
import tnmk.el.infrastructure.dictionary.oxford.entity.OxfordWord;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author khoi.tran on 2/24/17.
 */
@Service
public class OxfordService {
    @Value("${dictionary.oxford.app.id}")
    private String appId;

    @Value("${dictionary.oxford.app.key}")
    private String appKey;

    @Autowired
    private OxfordWordRepositories oxfordWordRepositories;

    public OxfordWord lookUp(String sourceLanguage, String word) {
        List<OxfordWord> oxfordWords = oxfordWordRepositories.findByLanguageAndWord(sourceLanguage, word);
        if (!oxfordWords.isEmpty()) return oxfordWords.get(0);

        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, Object> translateBody = new LinkedMultiValueMap<>();
//        String translateLanguage = sourceLanguage + "-" + destLanguage;
//        translateBody.add("text", originalText);
//        translateBody.add("lang", translateLanguage);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        headers.add("Accept", "application/json");
        headers.add("app_id", appId);
        headers.add("app_key", appKey);

        URI uri;
        try {
            String uriString = String.format("https://od-api-demo.oxforddictionaries.com:443/api/v1/entries/%s/%s", sourceLanguage, word);
            uri = new URI(uriString);
        } catch (URISyntaxException e) {
            throw new UnexpectedException(e.getMessage(), e);
        }
        RequestEntity<MultiValueMap<String, Object>> requestEntity = new RequestEntity<>(translateBody, headers, HttpMethod.POST, uri);
        ResponseEntity<OxfordResponse> responseEntity = restTemplate.exchange(requestEntity, OxfordResponse.class);
        if (responseEntity.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
            return null;
        }
        OxfordResponse oxfordResponse = responseEntity.getBody();
        oxfordWords = oxfordResponse.getResults();
        OxfordWord result = null;
        if (!oxfordWords.isEmpty()) {
            oxfordWordRepositories.save(oxfordWords);
            result = oxfordWords.get(0);
        }
        return result;
    }

}
