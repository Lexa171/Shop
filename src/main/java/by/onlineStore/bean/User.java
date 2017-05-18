package by.onlineStore.bean;

/**
 * Created by Admin on 14.05.2017.
 */
public class User {
    private Integer idUser;
    private String nameUser;
    private String password;
    private String mailUser;
    public User(){}

    public User(Integer id_user, String name_user, String mail_user) {
        idUser=id_user;
        nameUser=name_user;
        mailUser=mail_user;
    }

    public User(Integer id_user, String name_user, String password, String mail_user) {
        idUser=id_user;
        nameUser=name_user;
        this.password=password;
        mailUser=mail_user;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
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
    }}
