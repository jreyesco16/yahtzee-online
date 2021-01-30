package src;

import menu.Menu;
import menu.LobbyMenu;
import java.io.IOException;

public class CLI {

    private Menu menu;
    private static CLI instance;

    // singleton pattern to ensure single only one CLI instance
    public static CLI getCLI(){
        if(instance == null){
            instance = new CLI();
        }
        return instance;
    }

    //command pattern to allow easy modification and switch between menus
    public void run() throws IOException {
        CLI cli =  CLI.getCLI();
        cli.menu = new LobbyMenu();
        while(true) {
            cli.menu.displayMenu();
            cli.menu = cli.menu.getCommand().execute();
        }
    }

    public Menu getMenu() {
        return this.menu;
    }

    public void setMenu(Menu newMenu) {
        this.menu = newMenu;
    }

    // main function
    public static void main(String [] args) throws IOException {
        // run program until exit is executed
        new CLI().run();
    }
}

