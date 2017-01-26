package by.gregory.crud.model;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by User1 on 24.01.2017.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String userName;

    @Column(name = "age")
    private int userAge;

    @Column(name = "isAdmin")
    private boolean userIsAdmin;

    @Column(name = "createdDate")
    private LocalDateTime userCreatedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public boolean isUserIsAdmin() {
        return userIsAdmin;
    }

    public void setUserIsAdmin(boolean userIsAdmin) {
        this.userIsAdmin = userIsAdmin;
    }

    public LocalDateTime getUserCreateDate() {
        return userCreatedDate;
    }

    public void setUserCreateDate(LocalDateTime userCreateDate) {
        this.userCreatedDate = userCreateDate;
    }
}
