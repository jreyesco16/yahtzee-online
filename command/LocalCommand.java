package command;

import menu.Menu;

public class LocalCommand implements Command {

    @Override
    public Menu execute(){
        // user can play with up to four friends
        System.out.print("Playing locally");

        return null;
    }
}