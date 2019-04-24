package Model.users;

import javafx.beans.property.SimpleStringProperty;

import java.util.Objects;

public class Users {
    private String firstName, lastName, userName, password;

    public Users(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Users(String username) {
        this.userName = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return userName.equals(users.getUserName());
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}
