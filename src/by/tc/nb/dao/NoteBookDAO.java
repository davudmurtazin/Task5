package by.tc.nb.dao;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.dao.exception.DAOException;

import java.util.ArrayList;

public interface NoteBookDAO {

	void addNote(int userID, String content, String date) throws DAOException;

	ArrayList<Note> findNoteByContent(int userID, String strToFind) throws DAOException;

	ArrayList<Note> findNoteByDate(int userID, String dateToFind) throws DAOException;

	void clearNoteBook(int userID) throws DAOException;

	ArrayList<Note> showAllNotes(int userID) throws DAOException;


}
