package menu;

import command.Command;
import command.CreateGameCommand;

public class LobbyMenu extends Menu {

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

        System.out.println("\t\t\t\t1. Host a game");
        System.out.println("\t\t\t\t2. Join a game");
        System.out.println("\t\t\t\t3. Local play");
        System.out.println("\t\t\t\t0. Exit\n\n");
        
    }
    
    @Override
    public Command getCommand() {

        int selection = getSelection();

        return new CreateGameCommand(selection);
    }

    //get user selection from terminal/terminal
    @Override
    public int getSelection(){
        
        return getSelectionFromTerminal();
    }


}