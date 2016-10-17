package by.tc.nb.controller;

import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.notebook.*;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.service.exception.ServiceException;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Davud_Murtazin on 10/16/2016.
 */
public class NotebookMenuUtil {
    private static final Controller controller = new Controller();

    public static void addNote(int userID) throws ServiceException, DAOException, SQLException {
        System.out.println("Enter note to add: ");
        String content = new Scanner(System.in).nextLine();

        String dateStr = new SimpleDateFormat("dd.MM.yyyy").format(new Date());

        AddNoteRequest request = new AddNoteRequest();
        request.setCommandName("ADD_NEW_NOTE");
        request.setUserId(userID);
        request.setNote(content);
        request.setDate(dateStr);

        Response response = new Controller().doRequest(request);
        if((!response.isErrorStatus())){
            System.out.println(response.getErrorMessage());
        }
    }

    public static void findNoteByContent(int userID) throws ServiceException, DAOException, SQLException {
        System.out.println("Enter text to find: ");
        Scanner scFind = new Scanner(System.in);
        String strFind = scFind.nextLine();
        FindNoteByContentRequest request = new FindNoteByContentRequest();
        request.setCommandName("FIND_NOTE_BY_CONTENT");
        request.setContent(strFind);
        request.setUserID(userID);

        FindNoteByContentResponse response;
        response = (FindNoteByContentResponse) new Controller().doRequest(request);
        System.out.println("Notes containing: " + strFind);
        List<Note> foundNotesByContent;
        foundNotesByContent = response.getFoundNotes();
        if (foundNotesByContent.size()!=0){
            for (Note note : foundNotesByContent) {
                System.out.println(note);
            }
        } else {
            System.out.println("No matches found!");
        } if((!response.isErrorStatus())){
            System.out.println(response.getErrorMessage());
        }
    }

    public static void findNoteByDate(int userID) throws ServiceException, DAOException, SQLException {
        System.out.println("Enter date to find: ");
        Scanner scFind = new Scanner(System.in);
        String dateToFind = scFind.nextLine();
        FindNoteByDateRequest request = new FindNoteByDateRequest();
        request.setCommandName("FIND_NOTE_BY_DATE");
        request.setDate(dateToFind);
        request.setUserID(userID);

        FindNoteByDateResponse response;
        response = (FindNoteByDateResponse) new Controller().doRequest(request);
        ArrayList<Note> foundNotesByDate;
        foundNotesByDate = response.getFoundNotes();
        if (foundNotesByDate.size()!=0){
            for (Note note : foundNotesByDate) {
                System.out.println(note);
            }
        }
        else {
            System.out.println("No matches found!");
        }

        if(!response.isErrorStatus()){
            System.out.println(response.getErrorMessage());
        }
    }

    public static void clearNoteBook(int userID) throws ServiceException, DAOException, SQLException {
        ClearNoteBookRequest request = new ClearNoteBookRequest();
        request.setCommandName("CLEAT_NOTEBOOK");
        request.setUserID(userID);

        Response response = controller.doRequest(request);
        if(!response.isErrorStatus()){
            System.out.println(response.getErrorMessage());
        }
    }

    public static void showAllNotes(int userID) throws ServiceException, DAOException, SQLException {
        ShowNotesRequest request = new ShowNotesRequest();
        request.setCommandName("SHOW_NOTES");
        request.setUserID(userID);

        Response response;
        response = new Controller().doRequest(request);
        if(!response.isErrorStatus()){
            System.out.println(response.getErrorMessage());
        }
    }
}
