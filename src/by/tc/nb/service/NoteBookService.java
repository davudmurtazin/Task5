package by.tc.nb.service;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.service.exception.ServiceException;

import java.util.ArrayList;

public interface NoteBookService {
	
	void addNote(int userID, String content, String date) throws ServiceException, DAOException;

	ArrayList<Note> findNoteByContent(int userID, String strToFind) throws ServiceException, DAOException;

	ArrayList<Note> findNoteByDate(int userID, String dateToFind) throws ServiceException, DAOException;

	void clearNoteBook(int userID) throws ServiceException, DAOException;

	void showAllNotes(int userID) throws DAOException;
}
