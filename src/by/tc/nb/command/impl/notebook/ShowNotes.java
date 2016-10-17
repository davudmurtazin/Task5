package by.tc.nb.command.impl.notebook;

import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.notebook.ShowNotesRequest;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;

/**
 * Created by Davud_Murtazin on 9/29/2016.
 */
public class ShowNotes implements Command {
    @Override
    public Response execute(Request request) throws CommandException, ServiceException, DAOException {
        if(request instanceof ShowNotesRequest) {
            int userID = ((ShowNotesRequest) request).getUserID();

            ServiceFactory service = ServiceFactory.getInstance();
            NoteBookService nbService = service.getNoteBookService();

            nbService.showAllNotes(userID);

            Response response = new Response();
            response.setErrorStatus(false);
            response.setResultMessage("Show all notes!");

            return response;
        } else {
            throw new CommandException("Wrong request!");
        }
    }
}
