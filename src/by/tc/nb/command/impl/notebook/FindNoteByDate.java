package by.tc.nb.command.impl.notebook;

import by.tc.nb.bean.notebook.FindNoteByDateRequest;
import by.tc.nb.bean.notebook.FindNoteByDateResponse;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;

/**
 * Created by Davud_Murtazin on 9/29/2016.
 */
public class FindNoteByDate implements Command {
    @Override
    public Response execute(Request request) throws CommandException, DAOException {
        FindNoteByDateRequest req;

        if(request instanceof FindNoteByDateRequest) {
            req = (FindNoteByDateRequest) request;
        } else {
            throw new CommandException("Wrong request!");
        }

        int userID = req.getUserID();
        String dateToFind = req.getDate();

        ServiceFactory service = ServiceFactory.getInstance();
        NoteBookService nbService = service.getNoteBookService();

        FindNoteByDateResponse response = new FindNoteByDateResponse();
        try{
            response.setFoundNotes(nbService.findNoteByDate(userID, dateToFind));
            response.setErrorStatus(false);
            response.setResultMessage("Searching date found!");
        } catch (ServiceException e) {
            throw new CommandException("Wrong command!");
        }
        return response;
    }
}
