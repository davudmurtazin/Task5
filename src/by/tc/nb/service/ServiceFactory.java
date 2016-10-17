package by.tc.nb.service;

import by.tc.nb.service.impl.NoteBookServiceImpl;
import by.tc.nb.service.impl.UserServiceImpl;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();
	
	private NoteBookService nbService = new NoteBookServiceImpl();
	private UserService userService = new UserServiceImpl();

	public UserService getUserService() {
		return userService;
	}

	public static ServiceFactory getInstance(){
		return instance;
	}
	
	
	public NoteBookService getNoteBookService(){
		return nbService;
	}

}
