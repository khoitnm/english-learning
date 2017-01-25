package tnmk.el.service.historyevent.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author khoi.tran on 9/20/16.
 */
@Document(collection = "Tag")
public class Tag extends AuditableModel {
    /**
     * In this project, tag can has space, it can be a name, an event, a country, a time... in an event.
     */
    @Indexed
    private String tagValue;

    public String getTagValue() {
        return tagValue;
    }

    public void setTagValue(String tagValue) {
        this.tagValue = tagValue;
    }
}
