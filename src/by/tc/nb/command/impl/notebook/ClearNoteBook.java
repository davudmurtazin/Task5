package by.tc.nb.command.impl.notebook;

import by.tc.nb.bean.notebook.ClearNoteBookRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;

/**
 * Created by Davud_Murtazin on 9/30/2016.
 */
public class ClearNoteBook implements Command{

    @Override
    public Response execute(Request request) throws CommandException, ServiceException, DAOException {
        if (request instanceof ClearNoteBookRequest){
            int userID = ((ClearNoteBookRequest) request).getUserID();

            ServiceFactory service = ServiceFactory.getInstance();
            NoteBookService nbService = service.getNoteBookService();

            try {
                nbService.clearNoteBook(userID);
            } catch (ServiceException e) {
                throw new ServiceException("Can not clear the notebook!");
            }
            Response response = new Response();
            response.setErrorStatus(false);
            response.setResultMessage("NoteBook cleared!");

            return response;
        }
        else {
            throw new CommandException("Wrong command!!!");
        }
    }
}
