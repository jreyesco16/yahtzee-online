package menu;

import command.Command;
import command.GetGameMenuCommand;
import object.Guest;
import object.Host;

public class ScoresMenu extends Menu {

    // attributes
    private Host host;
    private Guest guest;
    private boolean isHost;

    // constructor
    public ScoresMenu(Host host, boolean isHost){
        this.host = host;
        this.isHost = isHost;
    }
    public ScoresMenu(Guest guest, boolean isHost){
        this.guest = guest;
        this.isHost = isHost;
    }


    @Override
    public void displayMenu(){

        
        System.out.print("░██████╗░█████╗░░█████╗░██████╗░███████╗░██████╗\n");
        System.out.print("██╔════╝██╔══██╗██╔══██╗██╔══██╗██╔════╝██╔════╝\n");
        System.out.print("╚█████╗░██║░░╚═╝██║░░██║██████╔╝█████╗░░╚█████╗░\n");
        System.out.print("░╚═══██╗██║░░██╗██║░░██║██╔══██╗██╔══╝░░░╚═══██╗\n");
        System.out.print("██████╔╝╚█████╔╝╚█████╔╝██║░░██║███████╗██████╔╝\n");
        System.out.print("╚═════╝░░╚════╝░░╚════╝░╚═╝░░╚═╝╚══════╝╚═════╝░\n\n");
        if(isHost){

            // display the ative player
            String active = "ACTIVE PLAYER: " + host.getGame().getAcitivePlayer().getName() + "\t";
            String rolls = "ROLLS: " + host.getGame().getCup().getRolls() + "\t";
            String round = "ROUND: " + host.getGame().getRound() + "\n";
            String scores = host.getGame().getScoresString() + "\n\n";


            String menu = "\n\n" + active + rolls + round + scores;

            System.out.print(menu);

            host.printToAllPlayers(menu);

        }else{

            // get menu from server
            System.out.print(this.guest.getConnection().read());

        }

        // defualt options to all players
        System.out.print("\n\n1. Go back\n\n");

    }


    @Override
    public Command getCommand(){

        int selection = getSelection();

        selection = selection == 1 ? 9 : 99;

        // details of command should be different depending on host or guest
        return isHost ? new GetGameMenuCommand(this.host, this.isHost, selection) : new GetGameMenuCommand(this.guest, this.isHost, selection);
    }

    @Override
    public int getSelection(){

        return isHost ? host.getHostSelection(host.getGame().getAcitivePlayer().getName()) : guest.getGuestSelection(guest.getConnection().read());
    }

}