package tnmk.el.service.historyevent.model;

import java.time.Instant;

/**
 * @author khoi.tran on 9/22/16.
 */
public class HistoryDateTime {
    private Instant dateTime;
    private DateTimeDetail dateTimeDetail;

    public Instant getDateTime() {
        return dateTime;
    }

    public void setDateTime(Instant dateTime) {
        this.dateTime = dateTime;
    }

    public DateTimeDetail getDateTimeDetail() {
        return dateTimeDetail;
    }

    public void setDateTimeDetail(DateTimeDetail dateTimeDetail) {
        this.dateTimeDetail = dateTimeDetail;
    }
}
