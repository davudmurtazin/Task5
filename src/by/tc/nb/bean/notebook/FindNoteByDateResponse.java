package by.tc.nb.bean.notebook;

import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.Note;

import java.util.ArrayList;

/**
 * Created by Davud_Murtazin on 9/30/2016.
 */
public class FindNoteByDateResponse extends Response {
    private ArrayList<Note> foundNotes;

    public ArrayList<Note> getFoundNotes() {
        return foundNotes;
    }

    public void setFoundNotes(ArrayList<Note> foundNotes) {
        this.foundNotes = foundNotes;
    }
}
