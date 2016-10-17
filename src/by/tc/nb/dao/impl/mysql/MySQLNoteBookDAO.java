package by.tc.nb.dao.impl.mysql;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.User;
import by.tc.nb.dao.NoteBookDAO;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.dao.impl.pool.AbstractDAO;
import by.tc.nb.source.UserProvider;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLNoteBookDAO extends AbstractDAO implements NoteBookDAO {
	public static final String INSERT_NOTE =
			"INSERT INTO `note` (UserID, Content, Date) VALUES (?, ?, ?)";
	public static final String DELETE_NOTES =
			"DELETE FROM `note` WHERE UserID = ?";
	public static final String SELECT_NOTES =
			"SELECT * FROM `note` WHERE UserID = ?";
	public static final String SELECT_NOTE_BY_CONTENT =
			"SELECT * FROM `note` WHERE UserID = ? AND Content = ?";
	public static final String SELECT_NOTE_BY_DATE =
			"SELECT * FROM `note` WHERE UserID = ? AND Date = ?";

	@Override
	public void addNote(int userID, String content, String date) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(INSERT_NOTE);
			preparedStatement.setInt(1, userID);
			preparedStatement.setString(2, content);
			preparedStatement.setString(3, date);
			System.out.println("addNoteDAO");
			preparedStatement.executeUpdate();
		} catch (DAOException | SQLException e) {
			throw new DAOException(e);
		} finally {
			closePreparedStatement(preparedStatement);
			releaseConnection(connection);
		}
	}

	@Override
	public ArrayList<Note> findNoteByContent(int userID, String strToFind) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Note> foundNotes = new ArrayList<>();
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(SELECT_NOTE_BY_CONTENT);
			preparedStatement.setInt(1, userID);
			preparedStatement.setString(2, strToFind);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				Note note = new Note();
				note.setNoteID(resultSet.getInt("NoteID"));
				note.setUserID(resultSet.getInt("UserID"));
				note.setContent(resultSet.getString("Content"));
				note.setDate(resultSet.getString("Date"));
				foundNotes.add(note);
			}
		} catch (DAOException | SQLException e) {
			throw new DAOException(e);
		} finally {
			closePreparedStatement(preparedStatement);
			releaseConnection(connection);
		}
		return foundNotes;
	}

	@Override
	public ArrayList<Note> findNoteByDate(int userID, String dateToFind) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Note> foundNotes = new ArrayList<>();
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(SELECT_NOTE_BY_DATE);
			preparedStatement.setInt(1, userID);
			preparedStatement.setString(2, dateToFind);


			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				Note note = new Note();
				note.setNoteID(resultSet.getInt("NoteID"));
				note.setUserID(resultSet.getInt("UserID"));
				note.setContent(resultSet.getString("Content"));
				note.setDate(resultSet.getString("Date"));

				foundNotes.add(note);
			}
		} catch (DAOException | SQLException e) {
			throw new DAOException(e);
		} finally {
			closePreparedStatement(preparedStatement);
			releaseConnection(connection);
		}
		return foundNotes;
	}

	@Override
	public void clearNoteBook( int userID) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(DELETE_NOTES);
			preparedStatement.setInt(1, userID);

			preparedStatement.executeUpdate();

		} catch (DAOException | SQLException e) {
			throw new DAOException(e);
		} finally {
			closePreparedStatement(preparedStatement);
			releaseConnection(connection);
		}
	}

	@Override
	public ArrayList<Note> showAllNotes(int userID) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Note> notes = new ArrayList<>();
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(SELECT_NOTES);
			preparedStatement.setInt(1,userID);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				Note note = new Note();
				note.setNoteID(resultSet.getInt("NoteID"));
				note.setUserID(resultSet.getInt("UserID"));
				note.setContent(resultSet.getString("Content"));
				note.setDate(resultSet.getString("Date"));

				notes.add(note);
			}
		} catch (DAOException | SQLException e) {
			throw new DAOException(e);
		} finally {
			closePreparedStatement(preparedStatement);
			releaseConnection(connection);
		}
		return notes;
	}
}
