package tnmk.el.service.historyevent.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author khoi.tran on 9/20/16.
 */
@ApiModel(description = "The event happened in history")
@Document(collection = "HistoryEvent")
public class HistoryEvent extends AuditableModel {
    @Indexed
    @ApiModelProperty("The time when event happened")
    private HistoryDateTime dateTime;
    @ApiModelProperty("The title of event, it can contain tagging code which reference to persons or areas.")
    private String title;
    @ApiModelProperty("The title of event, it can contain only plain text. There's no styling or tagging code which reference to persons or areas. The plain text is extracted from real title data")
    private String titlePlain;
    @ApiModelProperty("If you want to use title as summary, just let summary value empty.")
    private String summary;
    @ApiModelProperty("The summary of event, it can contain only plain text.")
    private String summaryPlain;
    @ApiModelProperty("The detail of event")
    private String detail;
    @ApiModelProperty("The detail of event, it can contain only plain text.")
    private String detailPlain;
    @Indexed
    @ApiModelProperty("Persons involed in event")
    @DBRef
    private List<Person> persons;
    @Indexed
    @ApiModelProperty("Places which event happened")
    @DBRef
    private List<EventLocation> locations;
    @Indexed
    @ApiModelProperty("Some tag the user want to put into this event so that he can categories it by himself. It should not be person or locations because we already has specific fields for them.")
    private List<String> tags;

    public HistoryDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(HistoryDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<EventLocation> getLocations() {
        return locations;
    }

    public void setLocations(List<EventLocation> locations) {
        this.locations = locations;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetailPlain() {
        return detailPlain;
    }

    public void setDetailPlain(String detailPlain) {
        this.detailPlain = detailPlain;
    }

    public String getSummaryPlain() {
        return summaryPlain;
    }

    public void setSummaryPlain(String summaryPlain) {
        this.summaryPlain = summaryPlain;
    }

    public String getTitlePlain() {
        return titlePlain;
    }

    public void setTitlePlain(String titlePlain) {
        this.titlePlain = titlePlain;
    }
}
