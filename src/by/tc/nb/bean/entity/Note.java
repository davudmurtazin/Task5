package by.tc.nb.bean.entity;

import java.io.Serializable;

public class Note{
    private int noteID;
    private int userID;
    private String content;
    private String date;

    public Note(){
    }

    public Note(int noteID, int userID, String content, String date) {
        this.noteID = noteID;
        this.userID = userID;
        this.content = content;
        this.date = date;
    }

    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteID=" + noteID +
                ", userID=" + userID +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
