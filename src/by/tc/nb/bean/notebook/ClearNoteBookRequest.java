package by.tc.nb.bean.notebook;

import by.tc.nb.bean.Request;

/**
 * Created by Davud_Murtazin on 9/30/2016.
 */
public class ClearNoteBookRequest extends Request {
    private int userID;

    public ClearNoteBookRequest() {
    }

    public ClearNoteBookRequest(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
