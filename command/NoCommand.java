package command;

import menu.Menu;

public class NoCommand implements Command {
    @Override
    public Menu execute(){
        // user selection is not an option
        System.out.print("\nInvalid selection, please try again.\n");

        return null;
    }
}