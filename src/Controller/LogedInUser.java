package Controller;

import Model.users.Professor;
import Model.users.Student;
import Model.users.Users;

public class LogedInUser {
    public static Users loggedInUser;

    public static Users getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(Users loggedInUser) {
        LogedInUser.loggedInUser = loggedInUser;
    }
}
