package by.tc.nb.command.impl.user;

import by.tc.nb.bean.user.RegisterRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.UserService;
import by.tc.nb.service.exception.ServiceException;

import java.sql.SQLException;

/**
 * Created by Davud_Murtazin on 10/13/2016.
 */
public class Register implements Command {

    @Override
    public Response execute(Request request) throws CommandException, ServiceException, DAOException, SQLException {
        RegisterRequest req;

        if(request instanceof RegisterRequest){
            req = (RegisterRequest)request;
        }else{
            throw new CommandException("Wrong request");
        }

        String name = req.getName();
        String login = req.getLogin();
        String password = req.getPassword();

        ServiceFactory service = ServiceFactory.getInstance();
        UserService userService = service.getUserService();

        try{
            userService.registration(name, login, password);
        } catch (ServiceException e) {
            throw new CommandException("Wrong command!");
        }
        Response response = new Response();
        response.setErrorStatus(false);
        response.setResultMessage("Note added!");

        return response;
    }
}
