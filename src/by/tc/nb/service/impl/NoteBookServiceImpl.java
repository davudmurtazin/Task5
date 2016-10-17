package by.tc.nb.service.impl;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.dao.FactoryDAO;
import by.tc.nb.dao.NoteBookDAO;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.exception.ServiceException;

import java.util.ArrayList;

public class NoteBookServiceImpl implements NoteBookService {

	@Override
	public void addNote(int userID, String content, String date) throws ServiceException, DAOException {
		if (content.isEmpty() || date.isEmpty() ||userID == 0){
			throw new ServiceException("Wrong parameters!");
		}
		NoteBookDAO noteBookDAO = FactoryDAO.getInstance().getNoteBookDAO();
		noteBookDAO.addNote(userID, content, date);
	}

	@Override
	public ArrayList<Note> findNoteByContent(int userID, String strToFind) throws ServiceException, DAOException {
		ArrayList<Note> foundNotes;
		if(strToFind.isEmpty() || userID==0){
			throw new ServiceException("Wrong parameter!");
		}
		else {
			NoteBookDAO noteBookDAO = FactoryDAO.getInstance().getNoteBookDAO();
			foundNotes = noteBookDAO.findNoteByContent(userID, strToFind);
		}
		return foundNotes;
	}

	@Override
	public ArrayList<Note> findNoteByDate(int userID, String dateToFind) throws ServiceException, DAOException {
		ArrayList<Note> foundNotes;
		if(dateToFind.isEmpty() || userID == 0){
			throw new ServiceException("Wrong parameter!");
		}
		NoteBookDAO noteBookDAO = FactoryDAO.getInstance().getNoteBookDAO();
		foundNotes = noteBookDAO.findNoteByDate(userID, dateToFind);
		return foundNotes;
	}

	@Override
	public void clearNoteBook(int userID) throws ServiceException, DAOException {
		try{
			NoteBookDAO noteBookDAO = FactoryDAO.getInstance().getNoteBookDAO();
			noteBookDAO.clearNoteBook(userID);
		}catch (DAOException e){
			throw new DAOException("Database is clear!");
		}

	}

	@Override
	public void showAllNotes(int userID) throws DAOException {
		try{
			NoteBookDAO noteBookDAO = FactoryDAO.getInstance().getNoteBookDAO();
			ArrayList<Note> notes = noteBookDAO.showAllNotes(userID);
			for(Note note : notes){
				System.out.println(note);
			}
		}catch (DAOException e){
			throw new DAOException("Could'n show notes!");
		}
	}
}
