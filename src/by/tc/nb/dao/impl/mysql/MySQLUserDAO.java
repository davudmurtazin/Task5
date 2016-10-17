package by.tc.nb.dao.impl.mysql;

import by.tc.nb.dao.UserDAO;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.dao.impl.pool.AbstractDAO;

import java.sql.*;

public class MySQLUserDAO extends AbstractDAO implements UserDAO {
	public static final String INSERT_USER =
			"INSERT INTO `user` (Name, Login, Password) VALUES (?, ?, ?)";
	public static final String SELECT_PERSON_BY_LOGIN_PASSWORD =
			"SELECT * FROM `user` WHERE Login = ? AND Password = ?;";

	@Override
	public int logination(String login, String password) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(SELECT_PERSON_BY_LOGIN_PASSWORD);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getInt("UserID");
			} else {
				return 0;
			}
		} catch (DAOException | SQLException e) {
			throw new DAOException(e);
		} finally {
			closePreparedStatement(preparedStatement);
			releaseConnection(connection);
		}
	}

	@Override
	public int registration(String name, String login, String password) throws DAOException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int userID = 0;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, login);
			preparedStatement.setString(3, password);
			preparedStatement.executeUpdate();

			String query = "SELECT UserID FROM user WHERE Login = '" + login + "' AND "
					+ "Password = '" + password + "';";
			try {
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query);

				while (rs.next()) {
					userID = rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException(e.getMessage());
			} finally {
				closePreparedStatement(preparedStatement);
				releaseConnection(connection);
			}
		}catch (DAOException e){
			throw new DAOException("Could not in register!");
		}
		return userID;
	}
}
