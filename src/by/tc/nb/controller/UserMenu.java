package by.tc.nb.controller;

import by.tc.nb.bean.*;
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

import static by.tc.nb.controller.NotebookMenuUtil.clearNoteBook;
import static by.tc.nb.controller.NotebookMenuUtil.findNoteByContent;
import static by.tc.nb.controller.NotebookMenuUtil.findNoteByDate;

/**
 * Created by Davud_Murtazin on 10/4/2016.
 */
public class UserMenu {
    private static final Scanner sc = new Scanner(System.in);

    private static boolean flag = true;

    private void getUserMenu(){
        System.out.println("Welcome to notebook organizer!=)\n" +
                "Please enter to: \n"+
                "1. Login \n" +
                "2. Registration \n" +
                "0. Exit");
    }

    private void getNoteBookMenu(){
        System.out.println("Welcome to notebook organizer!=)\n" +
                "Please enter to: \n"+
                "1. Add note \n" +
                "2. Find note by content \n" +
                "3. Find note by date \n" +
                "4. Clear notebook \n" +
                "5. Show all notes \n" +
                "0. Back to logination\n");
    }

    public void notebookMenu(int userID) throws ServiceException, DAOException, SQLException {
        while(flag){
            getNoteBookMenu();
            String choice = sc.nextLine();
            switch(choice){
                case "1": NotebookMenuUtil.addNote(userID); break;
                case "2": NotebookMenuUtil.findNoteByContent(userID); break;
                case "3": NotebookMenuUtil.findNoteByDate(userID); break;
                case "4": NotebookMenuUtil.clearNoteBook(userID); break;
                case "5": NotebookMenuUtil.showAllNotes(userID); break;
                case "0": userMenu();
                default: System.out.println("Incorrect command! Enter again: "); break;
            }
        }
    }

    public void userMenu() throws ServiceException, DAOException, SQLException {
        while(flag){
            int userID =0;
            getUserMenu();
            String choice = sc.nextLine();
            switch(choice){
                case "1": userID = UserMenuUtil.logination();
                    if(userID != 0){
                    notebookMenu(userID);
                } break;
                case "2": UserMenuUtil.registration(); break;
                case "0": flag = false;
                default: System.out.println("Incorrect command! Enter again: "); break;
            }
        }
    }



}
