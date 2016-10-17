package by.tc.nb.bean.entity;

import java.util.ArrayList;

/**
 * Created by Davud_Murtazin on 10/12/2016.
 */
public class User {
    private int userID;
    private String name;
    private String login;
    private String password;
    private ArrayList<Note> notes = new ArrayList<Note>();;

    public User(){
    }

    public User(int userID, String name, String login, String password, ArrayList<Note> notes) {
        this.userID = userID;
        this.name = name;
        this.login = login;
        this.password = password;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", notes=" + notes +
                '}';
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }
}
