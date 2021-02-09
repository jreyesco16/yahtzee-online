package menu;

import java.io.IOException;

import command.Command;
import command.ExitCommand;
import command.GetGameMenuCommand;
import object.Guest;
import object.Host;
import object.Player;

public class EndGameMenu extends Menu {

    // attribues
    private Player player;

    // constructor
    public EndGameMenu(Player player) {
        this.player = player;
    }

    @Override
    public void displayMenu() {
        System.out.println("\n\n\n");
        System.out.print("\t░░░██████╗░██████╗░░█████╗░███╗░░██╗██████╗░░░░██╗░░░░░░░██╗██╗███╗░░██╗███╗░░██╗███████╗██████╗░░░\n");
        System.out.print("\t░░██╔════╝░██╔══██╗██╔══██╗████╗░██║██╔══██╗░░░██║░░██╗░░██║██║████╗░██║████╗░██║██╔════╝██╔══██╗░░\n");
        System.out.print("\t░░██║░░██╗░██████╔╝███████║██╔██╗██║██║░░██║░░░╚██╗████╗██╔╝██║██╔██╗██║██╔██╗██║█████╗░░██████╔╝░░\n");
        System.out.print("\t░░██║░░╚██╗██╔══██╗██╔══██║██║╚████║██║░░██║░░░░████╔═████║░██║██║╚████║██║╚████║██╔══╝░░██╔══██╗░░\n");
        System.out.print("\t░░╚██████╔╝██║░░██║██║░░██║██║░╚███║██████╔╝░░░░╚██╔╝░╚██╔╝░██║██║░╚███║██║░╚███║███████╗██║░░██║░░\n");
        System.out.print("\t░░░╚═════╝░╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░╚══╝╚═════╝░░░░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚══╝╚═╝░░╚══╝╚══════╝╚═╝░░╚═╝░░\n\n");
        System.out.print("\t\t\t\t\tWinner: ");

        System.out.print(createMenu());

        System.out.print("\n\n\t\t\t\t\t1. Main Menu\n");
        System.out.print("\t\t\t\t\t0. Exit\n\n");
    }

    @Override
    public Command getCommand() {
        int selection = getSelection();
        switch(selection){
            case 1:
                return new GetGameMenuCommand(player, 9);
            case 0:
                return new ExitCommand();
        }

        return null;
    }

    @Override
    public int getSelection() {
        return getSelectionFromTerminal();
    }

    public String createMenu(){
        String menu = "";
        if(player.getHost()){
            Host host = (Host)player;

            // get winner
            menu = host.getGame().getWinner() + "\n";

            // print to guest
            if(host.getGame().getOnline()){
                host.printToAllPlayers(menu);
                // close server
                try {
                    host.getServer().getServerSocket().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }else{
            Guest guest = (Guest)player;
            menu = guest.getConnection().read();

             // close the connection to server
            try {
				guest.getConnection().getSocket().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }

        return menu;
    }

}