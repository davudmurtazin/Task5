package by.tc.nb.bean.notebook;

import by.tc.nb.bean.Request;

/**
 * Created by Davud_Murtazin on 9/29/2016.
 */
public class FindNoteByContentRequest extends Request {
    private String content;
    private int userID;

    public FindNoteByContentRequest() {
    }

    public FindNoteByContentRequest(String content, int userID) {
        this.content = content;
        this.userID = userID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
