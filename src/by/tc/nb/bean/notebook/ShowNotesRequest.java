package by.tc.nb.bean.notebook;

import by.tc.nb.bean.Request;

/**
 * Created by Davud_Murtazin on 9/29/2016.
 */
public class ShowNotesRequest extends Request {
    private int userID;

    public ShowNotesRequest() {
    }

    public ShowNotesRequest(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
