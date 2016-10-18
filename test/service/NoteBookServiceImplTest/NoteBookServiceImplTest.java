package service.NoteBookServiceImplTest;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.service.impl.NoteBookServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created by Davud_Murtazin on 10/17/2016.
 */
public class NoteBookServiceImplTest {
    private NoteBookServiceImpl noteBookService = new NoteBookServiceImpl();
    private Note note;
    private Note note1;
    private Note note2;

    @BeforeMethod
    public void setUp() throws Exception {
        note = new Note(4,1,"davud","18.10.2016");
        note1 = new Note(5,2,"epam","18.10.2016");
        note2 = new Note(3,3,"english", "17.10.2016");
    }

    @DataProvider(name = "createDataToFindNoteByContent")
    public Object[][] createDataToFindNote() {
        return new Object[][] {
                { 1, "davud", new ArrayList<Note>().add(note)},
                { 3, "english", new ArrayList<Note>().add(note1)},
                { 2, "epam", new ArrayList<Note>().add(note2)}};
    }

    @Test(dataProvider = "createDataToFindNoteByContent")
    public void testFindNoteByContent(int userID, String strToFind, ArrayList<Note> note) throws Exception {
        Assert.assertEquals(note, noteBookService.findNoteByContent(userID,strToFind));
    }

    @DataProvider(name = "createDataToFindNoteByData")
    public Object[][] createDataToFindNoteByData() {
        return new Object[][] {
                { 1, "18.10.2016", new ArrayList<Note>().add(note)}
                ,{ 3, "17.10.2016", new ArrayList<Note>().add(note2)}
                ,{ 2, "18.10.2016", new ArrayList<Note>().add(note1)}};
    }

    @Test(dataProvider = "createDataToFindNoteByData")
    public void testFindNoteByDate(int userID, String dateToFind, ArrayList<Note> noteResult) throws Exception {
        Assert.assertEquals(noteResult, noteBookService.findNoteByContent(userID,dateToFind));
    }

}