package menu;

import command.Command;

// abstract Menu class
abstract public class Menu {
    
    private Menu lastMenu;
    
    public void setLastMenu(Menu oldMenu) {
        lastMenu = oldMenu;
    }

    abstract public void displayMenu();
    abstract public Command getCommand(int selection);
}
