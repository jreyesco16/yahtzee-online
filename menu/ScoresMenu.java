package menu;

import command.Command;
import command.GetGameMenuCommand;
import object.Guest;
import object.Host;
import object.Player;

public class ScoresMenu extends Menu {

    // attributes
    private Player player;

    // constructor
    public ScoresMenu(Player player){
        this.player = player;
    }


    @Override
    public void displayMenu(){
        // PLAYER SCORES ??? (maybe will choose something different)
        System.out.println("\n\n\n");
        System.out.print("\t░░██████╗░██╗░░░░░░█████╗░██╗░░░██╗███████╗██████╗░░░░██████╗░█████╗░░█████╗░██████╗░███████╗░██████╗░░\n");
        System.out.print("\t░░██╔══██╗██║░░░░░██╔══██╗╚██╗░██╔╝██╔════╝██╔══██╗░░██╔════╝██╔══██╗██╔══██╗██╔══██╗██╔════╝██╔════╝░░\n");
        System.out.print("\t░░██████╔╝██║░░░░░███████║░╚████╔╝░█████╗░░██████╔╝░░╚█████╗░██║░░╚═╝██║░░██║██████╔╝█████╗░░╚█████╗░░░\n");
        System.out.print("\t░░██╔═══╝░██║░░░░░██╔══██║░░╚██╔╝░░██╔══╝░░██╔══██╗░░░╚═══██╗██║░░██╗██║░░██║██╔══██╗██╔══╝░░░╚═══██╗░░\n");
        System.out.print("\t░░██║░░░░░███████╗██║░░██║░░░██║░░░███████╗██║░░██║░░██████╔╝╚█████╔╝╚█████╔╝██║░░██║███████╗██████╔╝░░\n");
        System.out.print("\t░░╚═╝░░░░░╚══════╝╚═╝░░╚═╝░░░╚═╝░░░╚══════╝╚═╝░░╚═╝░░╚═════╝░░╚════╝░░╚════╝░╚═╝░░╚═╝╚══════╝╚═════╝░░░\n\n");



        System.out.print(createMenu());

        // defualt options to all players
        System.out.print("\n\n\t0. Go back\n\n");
    }


    @Override
    public Command getCommand(){

        int selection = getSelection();

        // details of command should be different depending on host or guest
        return new GetGameMenuCommand(player, 0);
    }

    @Override
    public int getSelection(){

        Host host = null;
        Guest guest = null;

        String activePlayer = "";

        if(player.getHost()){
            host = (Host)player;
            activePlayer = host.getGame().getActivePlayer().getName();
            if(host.getGame().getOnline()){
                host.printToAllPlayers(activePlayer);
            }
        }else{
            guest = (Guest)player;
            activePlayer = guest.getConnection().read();
        }
    
        return player.getHost() ? host.getHostSelection(activePlayer) : guest.getGuestSelection(activePlayer);
    }

    public String createMenu(){
        String menu = "";
        if(player.getHost()){
            Host host = (Host)player;
            
            String active = "\t\tACTIVE PLAYER: " + host.getGame().getActivePlayer().getName() + "\t";
            String rolls = "ROLLS: " + host.getGame().getCup().getRolls() + "\t";
            String round = "ROUND: " + host.getGame().getRound() + "\n";
            String scores = host.getGame().getScoresString() + "\n\n";


            menu = "\n\n" + active + rolls + round + scores;

            if(host.getGame().getOnline()){
                host.printToAllPlayers(menu);
            }

        }else{
            Guest guest = (Guest)player;
            menu = guest.getConnection().read();
        }

        return menu;
    }

}