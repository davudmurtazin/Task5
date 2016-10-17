package by.tc.nb.controller;

import by.tc.nb.bean.Response;
import by.tc.nb.bean.user.LoginRequest;
import by.tc.nb.bean.user.LoginResponse;
import by.tc.nb.bean.user.RegisterRequest;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Davud_Murtazin on 10/16/2016.
 */
public class UserMenuUtil {

    public static int logination() throws ServiceException, DAOException, SQLException {
        System.out.println("Enter login: ");
        String login = new Scanner(System.in).nextLine();

        System.out.println("Enter password: ");
        String password = new Scanner(System.in).nextLine();

        LoginRequest request = new LoginRequest();
        request.setCommandName("LOGIN");
        request.setLogin(login);
        request.setPassword(password);

        LoginResponse response = (LoginResponse) new Controller().doRequest(request);
        if((!response.isErrorStatus())){
            System.out.println(response.getErrorMessage());
        }
        return response.getUserID();
    }

    public static void registration() throws ServiceException, DAOException, SQLException {
        System.out.println("Enter name: ");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Enter login: ");
        String login = new Scanner(System.in).nextLine();

        System.out.println("Enter password: ");
        String password = new Scanner(System.in).nextLine();

        RegisterRequest request = new RegisterRequest();
        request.setCommandName("REGISTER");
        request.setName(name);
        request.setLogin(login);
        request.setPassword(password);

        Response response = new Controller().doRequest(request);
        if((!response.isErrorStatus())){
            System.out.println(response.getErrorMessage());
        }
    }
}
