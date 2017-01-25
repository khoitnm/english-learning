package tnmk.el.service.historyevent.model;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import tnmk.common.util.StringUtil;

/**
 * @author khoi.tran on 9/20/16.
 */
@Document(collection = "Person")
public class Person extends AuditableModel {
    @Indexed
    private String firstName;
    @Indexed
    private String middleName;
    @Indexed
    private String lastName;

    private HistoryDateTime birthDate;
    @ApiModelProperty("If null, it means unknown.")
    private HistoryDateTime deathDate;

    @ApiModelProperty("The ancient nationality")
    private String nationality;

    @ApiModelProperty("This field is calculated from firstName, middleName and lastName")
    public String getFullName() {
        return StringUtil.joinNotBlankStrings(" ", firstName, middleName, lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public HistoryDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(HistoryDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public HistoryDateTime getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(HistoryDateTime deathDate) {
        this.deathDate = deathDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
