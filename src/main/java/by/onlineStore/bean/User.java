package by.onlineStore.bean;

import by.onlineStore.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Admin on 14.05.2017.
 */
@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = "name_User") })
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_User", unique = true, nullable = false)
    private Long idUser;
    @Column(name = "name_User", unique = true, nullable = false, length = 20)
    private String nameUser;
    @Column(name = "password", nullable = false, length = 30)
    private String password;
    @Column(name = "mail_User", length = 40, unique = true)
    private String mailUser;

    public User() {
    }

    public User(Long id_user, String name_user, String mail_user) {
        idUser = id_user;
        nameUser = name_user;
        mailUser = mail_user;
    }

    public User(Long id_user, String name_user, String password, String mail_user) {
        idUser = id_user;
        nameUser = name_user;
        this.password = password;
        mailUser = mail_user;
    }
    public User(UserDto userDto) {
        idUser = userDto.getUserId();
        nameUser = userDto.getUserName();
        this.password = userDto.getUserPassword();
        mailUser = userDto.getUserMail();
    }


    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMailUser() {
        return mailUser;
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    @Override
    public String toString() {
        return "User INFO [ID: " + idUser + ", Name: " + nameUser + "]";
    }
}
