package menu;

import command.Command;
import command.ExitCommand;
import command.OnlineCommand;
import command.LocalCommand;
import command.NoCommand;

public class Lobby extends Menu {

    //print out Lobby menu
    public void displayMenu() {
        System.out.println("\n\n\n");
        System.out.println("██╗░░░██╗░█████╗░██╗░░██╗████████╗███████╗███████╗███████╗░░░░░█████╗░███╗░░██╗██╗░░░░░██╗███╗░░██╗███████╗");
        System.out.println("╚██╗░██╔╝██╔══██╗██║░░██║╚══██╔══╝╚════██║██╔════╝██╔════╝░░░░██╔══██╗████╗░██║██║░░░░░██║████╗░██║██╔════╝");
        System.out.println("░╚████╔╝░███████║███████║░░░██║░░░░░███╔═╝█████╗░░█████╗░░░░░░██║░░██║██╔██╗██║██║░░░░░██║██╔██╗██║█████╗░░");
        System.out.println("░░╚██╔╝░░██╔══██║██╔══██║░░░██║░░░██╔══╝░░██╔══╝░░██╔══╝░░░░░░██║░░██║██║╚████║██║░░░░░██║██║╚████║██╔══╝░░");
        System.out.println("░░░██║░░░██║░░██║██║░░██║░░░██║░░░███████╗███████╗███████╗░░░░╚█████╔╝██║░╚███║███████╗██║██║░╚███║███████╗");
        System.out.println("░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░╚══════╝╚══════╝╚══════╝░░░░░╚════╝░╚═╝░░╚══╝╚══════╝╚═╝╚═╝░░╚══╝╚══════╝");
        System.out.println("\t\t\t██╗░░░░░░█████╗░██████╗░██████╗░██╗░░░██╗");
        System.out.println("\t\t\t██║░░░░░██╔══██╗██╔══██╗██╔══██╗╚██╗░██╔╝");
        System.out.println("\t\t\t██║░░░░░██║░░██║██████╦╝██████╦╝░╚████╔╝░");
        System.out.println("\t\t\t██║░░░░░██║░░██║██╔══██╗██╔══██╗░░╚██╔╝░░");
        System.out.println("\t\t\t███████╗╚█████╔╝██████╦╝██████╦╝░░░██║░░░");
        System.out.println("\t\t\t╚══════╝░╚════╝░╚═════╝░╚═════╝░░░░╚═╝░░░\n");

        System.out.println("1. Host a game");
        System.out.println("2. Join a game");
        System.out.println("3. Local play");
        System.out.println("0. Exit\n\n");
        
    }
        
    public Command getCommand(int selection) {
        switch(selection){
            case 1:
                return new OnlineCommand(selection);

            case 2:
                return new OnlineCommand(selection);

            case 3:
                return new LocalCommand();

            case 0:
                return new ExitCommand();
        }
        // no command found
        return new NoCommand();
    }
}