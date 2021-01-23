package menu;

import java.io.IOException;

import command.Command;
import command.ExitCommand;
import command.GetGameMenuCommand;
import object.Guest;
import object.Host;

public class EndGameMenu extends Menu {

    // attribues
    private Host host;
    private Guest guest;
    private boolean isHost;
    private int selection;

    // constructor
    public EndGameMenu(Host host, boolean isHost, int selection) {
        this.host = host;
        this.isHost = isHost;
        this.selection = selection;
    }
    public EndGameMenu(Guest guest, boolean isHost, int selection){
        this.guest = guest;
        this.isHost = isHost;
        this.selection = selection;
    }

    @Override
    public void displayMenu() {

        System.out.print("░██╗░░░░░░░██╗██╗███╗░░██╗███╗░░██╗███████╗██████╗░\n");
        System.out.print("░██║░░██╗░░██║██║████╗░██║████╗░██║██╔════╝██╔══██╗\n");
        System.out.print("░╚██╗████╗██╔╝██║██╔██╗██║██╔██╗██║█████╗░░██████╔╝\n");
        System.out.print("░░████╔═████║░██║██║╚████║██║╚████║██╔══╝░░██╔══██╗\n");
        System.out.print("░░╚██╔╝░╚██╔╝░██║██║░╚███║██║░╚███║███████╗██║░░██║\n");
        System.out.print("░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚══╝╚═╝░░╚══╝╚══════╝╚═╝░░╚═╝\n\n");

        System.out.print("  Winner: ");
        
        if(this.isHost){

            // get winner
            String winner = this.host.getGame().getWinner();

            // print to guest
            this.host.printToAllPlayers(winner);

            System.out.print(winner + "\n");

            // close server
            try {
                this.host.getServer().getServerSocket().close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else{
            String winner = this.guest.getConnection().read();

            System.out.print(winner + "\n");

            // close the connection to server
            try {
				this.guest.getConnection().getSocket().close();
			} catch (IOException e) {
				e.printStackTrace();
			}

        }

        System.out.print("\n\n1. Main Menu\n");
        System.out.print("0. Exit\n\n");

    }

    @Override
    public Command getCommand() {
        int selection = getSelection();
        switch(selection){
            case 1:
                return this.isHost ? new GetGameMenuCommand(this.host, this.isHost, 0) : new GetGameMenuCommand(this.guest, this.isHost, this.selection);
            case 0:
                return new ExitCommand();
        }

        return null;
    }

    @Override
    public int getSelection() {
        return getSelectionFromTerminal();
    }

}
