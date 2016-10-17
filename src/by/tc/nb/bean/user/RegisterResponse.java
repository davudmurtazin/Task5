package by.tc.nb.bean.user;

import by.tc.nb.bean.Response;

/**
 * Created by Davud_Murtazin on 10/16/2016.
 */
public class RegisterResponse extends Response {
    private int userID;

    public RegisterResponse() {
    }

    public RegisterResponse(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
