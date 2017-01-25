package tnmk.el.service.historyevent.model;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author khoi.tran on 9/20/16.
 */
@Document(collection = "EventLocation")
public class EventLocation extends AuditableModel {
    private String displayName;

    @ApiModelProperty("We not use it for now when we let user add their map image, but maybe used in the future.")
    @Deprecated
    private String imageId;

    @ApiModelProperty("Position can be latlong, country code or position on screen? (I suggest it should be latlong, so it can be independent on UI)")
    private String position;

    @DBRef
    @ApiModelProperty("One ancient countries can be equals to some modern locations. Each location can be a province of a country. It should follow ISO 3166-2 (standard for provinces on the world)")
    private List<ModernArea> modernAreas;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<ModernArea> getModernAreas() {
        return modernAreas;
    }

    public void setModernAreas(List<ModernArea> modernAreas) {
        this.modernAreas = modernAreas;
    }
}
