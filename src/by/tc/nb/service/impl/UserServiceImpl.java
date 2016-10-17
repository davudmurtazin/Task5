package by.tc.nb.service.impl;

import by.tc.nb.dao.FactoryDAO;
import by.tc.nb.dao.UserDAO;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.service.UserService;
import by.tc.nb.service.exception.ServiceException;

import java.sql.SQLException;

/**
 * Created by Davud_Murtazin on 10/16/2016.
 */
public class UserServiceImpl implements UserService {

    @Override
    public int logination(String login, String password) throws ServiceException, DAOException {
        if (login.isEmpty() || password.isEmpty()) {
            throw new ServiceException("Arguments for loginagion are empty!");
        }
        try{
            UserDAO userDAO = FactoryDAO.getInstance().getUserDAO();
            int checker = userDAO.logination(login,password);
            if (checker != 0) {
                return checker;
            } else {
                return 0;
            }
        }catch (DAOException e){
            throw new DAOException("Registration fail!");
        }
    }

    @Override
    public int registration(String name, String login, String password) throws ServiceException, DAOException, SQLException {
        int userID;
        if (name.isEmpty() || login.isEmpty() || password.isEmpty()) {
            throw new ServiceException("Arguments for registration are empty!");
        } else {
            try{
                UserDAO userDAO = FactoryDAO.getInstance().getUserDAO();
                userID = userDAO.registration(name, login, password);
            }catch (DAOException e){
                throw new DAOException("Registration fail!");
            }

        }
        return userID;
    }
}
