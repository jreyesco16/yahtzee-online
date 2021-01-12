package command;

public class ExitCommand implements Command {
	public void execute() {
		// overwrite the execute() to exit the system
		System.out.print("\nThank you for playing.\n");
		System.exit(0);
	}
}
