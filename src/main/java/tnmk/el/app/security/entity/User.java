package tnmk.el.app.security.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import tnmk.el.app.common.entity.BaseEntity;

import java.util.List;

/**
 * @author khoi.tran on 1/28/17.
 */
@Document(collection = "User")
public class User extends BaseEntity {
    @NotBlank
    @Indexed(unique = true)
    private String username;
    @NotBlank
    private String password;
    @Email
    private String email;
    private List<String> roles;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
