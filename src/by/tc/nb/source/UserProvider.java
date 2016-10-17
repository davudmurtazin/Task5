package by.tc.nb.source;

import by.tc.nb.bean.entity.User;

/**
 * Created by Davud_Murtazin on 10/12/2016.
 */
public class UserProvider {
    private static UserProvider instance = new UserProvider();
    private User user;

    public UserProvider(){
        user = new User();
    }

    public static UserProvider getInstance() {
        return instance;
    }

    public User getUser() {
        return user;
    }
}
