package tnmk.el.app.common.entity;

import org.springframework.data.annotation.Id;

import java.time.Instant;

/**
 * @author khoi.tran on 1/25/17.
 */
public class BaseEntity {
    @Id
    private String id;
    private Instant createdDateTime = Instant.now();
    private Instant updatedDateTime;

    public Instant getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Instant createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Instant getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(Instant updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public String getOxfordWordId() {
        return id;
    }

    public void setOxfordWordId(String id) {
        this.id = id;
    }
}
