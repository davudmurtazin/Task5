package by.tc.nb.command.impl.notebook;

import by.tc.nb.bean.notebook.FindNoteByContentRequest;
import by.tc.nb.bean.notebook.FindNoteByContentResponse;
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
public class FindNoteByContent implements Command {
    @Override
    public Response execute(Request request) throws CommandException, ServiceException, DAOException {
        FindNoteByContentRequest req;
        if(request instanceof FindNoteByContentRequest) {
            req = (FindNoteByContentRequest)request;
        } else {
            throw new CommandException("Wrong request!");
        }
        String strToFind = req.getContent();
        int userID = req.getUserID();

        ServiceFactory service = ServiceFactory.getInstance();
        NoteBookService nbService = service.getNoteBookService();
        try{
            nbService.findNoteByContent(userID, strToFind);
        }catch (ServiceException e){
            throw new ServiceException("Can not find note!");
        }
        FindNoteByContentResponse response = new FindNoteByContentResponse();
        try{
            response.setFoundNotes(nbService.findNoteByContent(userID, strToFind));
            response.setErrorStatus(false);
            response.setResultMessage("Searching string found!");
        } catch (ServiceException e) {
            throw new ServiceException("Wrong command!");
        }
        return response;
    }
}
