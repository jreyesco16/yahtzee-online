package command;

public class NoCommand implements Command {
    @Override
    public void execute(){
        // user selection is not an option
        System.out.print("\nInvalid selection, please try again.\n");
    }
}