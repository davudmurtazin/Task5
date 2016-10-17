package by.tc.nb.command;

import by.tc.nb.command.impl.notebook.*;
import by.tc.nb.command.impl.user.Login;
import by.tc.nb.command.impl.user.Register;

import java.util.HashMap;
import java.util.Map;

public class CommandHelper {

	private Map<String, Command> commands = new HashMap<String, Command>();

	public CommandHelper() {
		commands.put("LOGIN", new Login());
		commands.put("REGISTER", new Register());
		commands.put("ADD_NEW_NOTE", new AddNewNote());
		commands.put("FIND_NOTE_BY_CONTENT", new FindNoteByContent());
		commands.put("FIND_NOTE_BY_DATE", new FindNoteByDate());
		commands.put("SHOW_NOTES", new ShowNotes());
		commands.put("CLEAT_NOTEBOOK", new ClearNoteBook());
	}

	public Command getCommand(String commandName) {
		Command command;
		command = commands.get(commandName);
		return command;
	}
}
