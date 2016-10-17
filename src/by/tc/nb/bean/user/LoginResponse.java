package by.tc.nb.bean.user;

import by.tc.nb.bean.Response;

/**
 * Created by Davud_Murtazin on 10/16/2016.
 */
public class LoginResponse extends Response{
    private int userID;

    public LoginResponse() {
    }

    public LoginResponse(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
