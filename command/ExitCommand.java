package command;

import menu.Menu;

public class ExitCommand implements Command {

	@Override
	public Menu execute() {
		// overwrite the execute() to exit the system
		System.out.print("\n\n\t\t\t\t  Thank you for playing.\n\n");
		System.exit(0);
		return null;
	}
}