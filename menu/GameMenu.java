package menu;

import java.io.IOException;

import command.Command;
import command.GetGameMenuCommand;
import object.Guest;
import object.Host;

public class GameMenu extends Menu {

    // attributes
    private Host host;
    private Guest guest;
    private boolean isHost;

    // constructor
    public GameMenu(Host host, boolean isHost) {
        this.host = host;
        this.isHost = isHost;
    }

    public GameMenu(Guest guest, boolean isHost) {
        this.guest = guest;
        this.isHost = isHost;
    }

    // show how's turn is it, show eligible options to players
    @Override
    public void displayMenu() {

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n");
        
        System.out.print("██╗░░░██╗░█████╗░██╗░░██╗████████╗███████╗███████╗███████╗\n");
        System.out.print("╚██╗░██╔╝██╔══██╗██║░░██║╚══██╔══╝╚════██║██╔════╝██╔════╝\n");
        System.out.print("░╚████╔╝░███████║███████║░░░██║░░░░░███╔═╝█████╗░░█████╗░░\n");
        System.out.print("░░╚██╔╝░░██╔══██║██╔══██║░░░██║░░░██╔══╝░░██╔══╝░░██╔══╝░░\n");
        System.out.print("░░░██║░░░██║░░██║██║░░██║░░░██║░░░███████╗███████╗███████╗\n");
        System.out.print("░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░╚══════╝╚══════╝╚══════╝\n");

        if(isHost){

            // display the ative player
            String active = "ACTIVE PLAYER: " + host.getGame().getAcitivePlayer().getName() + "\t";

            String round = "ROUND: " + host.getGame().getRound() + "\n";

            // print the score board(unsorted)
            String scoreBoard = host.getGame().getScoreBoard();

            // get dice for active player
            String diceString = host.getGame().getCup().getDiceBuilderString();

            // have to get rolls after getting the dice string
            String rolls = "ROLLS: " + host.getGame().getCup().getRolls() + "\t";

            String menu = "\n\n" + scoreBoard + active + rolls + round + diceString;

            System.out.print(menu);

            host.printToAllPlayers(menu);

        }else{

            // get menu from server
            System.out.print(this.guest.getConnection().read());

        }

        // defualt options to all players
        System.out.print("\n\n\t\t\t\t1. Roll Dice\n");
        System.out.print("\t\t\t\t2. Select Combo\n");
        System.out.print("\t\t\t\t3. View Scores\n");
        System.out.print("\t\t\t\t0. Exit\n\n");
    }

    @Override
    public Command getCommand(){

        int selection = getSelection();
        // details of command should be different depending on host or guest
        return isHost ? new GetGameMenuCommand(this.host, this.isHost, selection) : new GetGameMenuCommand(this.guest, this.isHost, selection);
    }

    @Override
    public int getSelection(){
    
        return isHost ? host.getHostSelection(host.getGame().getAcitivePlayer().getName()) : guest.getGuestSelection(guest.getConnection().read());
    }

    // getters and setters
    public Host getHost(){
        return this.host;
    }
    public void setHost(Host host){
        this.host = host;
    }
    public boolean getIsHost(){
        return this.isHost;
    }
    public void setIsHost(boolean isHost){
        this.isHost = isHost;
    }
    
}