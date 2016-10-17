package by.tc.nb.dao;

import by.tc.nb.dao.exception.DAOException;

import java.sql.SQLException;

public interface UserDAO {
	int logination(String login, String password) throws DAOException;
	int registration(String name, String login, String password) throws DAOException, SQLException;
}
