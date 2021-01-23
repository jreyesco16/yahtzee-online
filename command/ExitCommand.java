package command;

import menu.Menu;

public class ExitCommand implements Command {

	@Override
	public Menu execute() {
		// overwrite the execute() to exit the system
		System.out.print("\nThank you for playing.\n");
		System.exit(0);
		return null;
	}
}
