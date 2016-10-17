package by.tc.nb.bean.notebook;

import by.tc.nb.bean.Request;

/**
 * Created by Davud_Murtazin on 9/29/2016.
 */
public class FindNoteByDateRequest extends Request {
    private int userID;
    private String date;

    public FindNoteByDateRequest() {
    }

    public FindNoteByDateRequest(int userID, String date) {
        this.userID = userID;
        this.date = date;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
