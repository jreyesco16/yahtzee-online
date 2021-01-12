package src;

import menu.Menu;
import menu.Lobby;

import java.io.IOException;
import java.util.Scanner;

public class CLI {
    private Menu menu;
    private Menu lastMenu;
    private static CLI instance;

    // singleton pattern to ensure single only one CLI instance
    public static CLI getCLI(){
        if(instance == null){
            instance = new CLI();
            System.out.print("Singleton instance of CLI created for the first time.\n");
        }
        return instance;
    }

    //command pattern to allow easy modification and switch between menus
    public void run() throws IOException {
        int selection;
        CLI cli =  CLI.getCLI();
        cli.menu = new Lobby();
        while(true) {
            cli.menu.displayMenu();
            selection = getSelection();
            cli.menu.getCommand(selection).execute();
        }
    }

    //get user selection from terminal/terminal
    private int getSelection(){
        System.out.print("Enter Selection: ");
        Scanner sc = new Scanner(System.in);
        int selection = 10000000;

        String selecTmp = sc.nextLine();

        try{
            selection = Integer.parseInt(selecTmp);
        }catch(Exception e){
            // user entered a selection that isn't an option
        }

        // sc.close();

        return selection;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public void setMenu(Menu newMenu) {
        newMenu.setLastMenu(this.menu);
        this.menu = newMenu;
    }

    public void setLastMenu(Menu lastMenu) {
        this.lastMenu = lastMenu;
    }

    public Menu getLastMenu() {
        return lastMenu;
    }

    // main function
    public static void main(String [] args) throws IOException {

        CLI cli = CLI.getCLI();
        // run program until exit is executed
        cli.run();
    }
}

