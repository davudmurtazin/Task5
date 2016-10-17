package by.tc.nb.dao;

import by.tc.nb.dao.impl.mysql.MySQLNoteBookDAO;
import by.tc.nb.dao.impl.mysql.MySQLUserDAO;

/**
 * Created by Davud_Murtazin on 10/12/2016.
 */
public class FactoryDAO {
    private static final FactoryDAO instance = new FactoryDAO();

    private NoteBookDAO noteBookDAO = new MySQLNoteBookDAO();
    private UserDAO userDAO = new MySQLUserDAO();


    public static FactoryDAO getInstance(){
        return instance;
    }

    public NoteBookDAO getNoteBookDAO(){
        return noteBookDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
}
