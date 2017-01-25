package tnmk.el.service.historyevent.model;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author khoi.tran on 9/20/16.
 */
@Document(collection = "ModernArea")
public class ModernArea extends AuditableModel {
    private String id;
    private String parentId;
    @DBRef
    private List<ModernArea> children;
    /**
     * View more at {@link ModernAreaLevel}
     */
    private ModernAreaLevel level;
    private String isoCode;
    /**
     * Not sure we need it, isoCode can be used as logicName
     */
    @ApiModelProperty("Not sure we need it, isoCode can be used as logicName")
    private String logicName;
    private String displayName;
    private String sharpData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getLogicName() {
        return logicName;
    }

    public void setLogicName(String logicName) {
        this.logicName = logicName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getSharpData() {
        return sharpData;
    }

    public void setSharpData(String sharpData) {
        this.sharpData = sharpData;
    }

    public List<ModernArea> getChildren() {
        return children;
    }

    public void setChildren(List<ModernArea> children) {
        this.children = children;
    }

    public ModernAreaLevel getLevel() {
        return level;
    }

    public void setLevel(ModernAreaLevel level) {
        this.level = level;
    }
}
