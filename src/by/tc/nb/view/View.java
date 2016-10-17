package by.tc.nb.view;

import by.tc.nb.controller.UserMenu;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.service.exception.ServiceException;

import java.sql.SQLException;

public class View {
	public static void main(String[] args) throws ServiceException, DAOException, SQLException {
		UserMenu userMenu = new UserMenu();
		userMenu.userMenu();
	}
}
