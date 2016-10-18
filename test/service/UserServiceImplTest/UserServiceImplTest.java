package service.UserServiceImplTest;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.service.impl.UserServiceImpl;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created by Davud_Murtazin on 10/17/2016.
 */
public class UserServiceImplTest {
    private UserServiceImpl userService = new UserServiceImpl();

    @DataProvider(name = "createDataToFindNoteByData")
    public Object[][] createDataToFindNoteByData() {
        return new Object[][] {
                { "davud", "davud95", 1}
                ,{ "murta", "murtaz", 2}
                ,{ "minsk", "minsk16", 3}};
    }

    @Test(dataProvider = "createDataToFindNoteByData")
    public void testFindNoteByDate(String login, String password, int userID) throws Exception {
        Assert.assertEquals(userID, userService.logination(login,password));
    }
}