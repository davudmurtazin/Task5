package by.tc.nb.service;

import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.service.exception.ServiceException;

import java.sql.SQLException;

/**
 * Created by Davud_Murtazin on 10/13/2016.
 */
public interface UserService{

    int logination(String login, String password) throws ServiceException, DAOException;
    int registration(String name, String login, String password) throws ServiceException, DAOException, SQLException;
}
