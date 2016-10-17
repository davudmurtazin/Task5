package by.tc.nb.command.impl.notebook;

import by.tc.nb.bean.notebook.AddNoteRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;

public class AddNewNote implements Command {

	@Override
	public Response execute(Request request) throws CommandException, DAOException {
		AddNoteRequest req;

		if(request instanceof AddNoteRequest){
			req = (AddNoteRequest)request;
		}else{
			throw new CommandException("Wrong request");
		}

		int userID = req.getUserID();
		String content = req.getNote();
		String date = req.getDate();
		System.out.println("execute AddNewNote" +userID+content+date);
		ServiceFactory service = ServiceFactory.getInstance();
		NoteBookService nbService = service.getNoteBookService();

		try{
			nbService.addNote(userID, content, date);
		} catch (ServiceException e) {
			throw new CommandException("Wrong command!");
		}
        Response response = new Response();
		response.setErrorStatus(false);
		response.setResultMessage("Note added!");

		return response;
	}

}
