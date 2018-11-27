package fr.demo.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Une entity très simple : sans configuration particulière.
 * 
 * @author Gaël Sigogneau
 * @since 21 nov. 2018
 *
 */
@Entity
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private String login;
    private String password;

    public UserEntity() {
    }

    public UserEntity(String login, String password) {
        super();
        this.login = login;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserEntity [id=");
        builder.append(id);
        builder.append(", login=");
        builder.append(login);
        builder.append(", password=");
        builder.append(password);
        builder.append("]");
        return builder.toString();
    }

}
