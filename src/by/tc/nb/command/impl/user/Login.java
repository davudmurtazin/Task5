package by.tc.nb.command.impl.user;

import by.tc.nb.bean.user.LoginRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.user.LoginResponse;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.UserService;
import by.tc.nb.service.exception.ServiceException;

/**
 * Created by Davud_Murtazin on 10/13/2016.
 */
public class Login implements Command{

    @Override
    public Response execute(Request request) throws CommandException, ServiceException, DAOException {
        LoginRequest req;

        if(request instanceof LoginRequest){
            req = (LoginRequest)request;
        }else{
            throw new CommandException("Wrong request");
        }

        String login = req.getLogin();
        String password = req.getPassword();

        ServiceFactory service = ServiceFactory.getInstance();
        UserService userService = service.getUserService();

        LoginResponse response = new LoginResponse();
        try{
            if (userService.logination(login, password) != 0) {
                response.setUserID(userService.logination(login, password));
                response.setErrorStatus(false);
                response.setResultMessage("Logination access!");
            }else {
                response.setErrorStatus(true);
                response.setResultMessage("Logination failed!");
            }
        } catch (ServiceException e) {
            throw new CommandException("Wrong command!");
        }
        return response;
    }
}
