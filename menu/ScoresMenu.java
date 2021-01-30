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
        
        System.out.print("░██████╗░█████╗░░█████╗░██████╗░███████╗░██████╗\n");
        System.out.print("██╔════╝██╔══██╗██╔══██╗██╔══██╗██╔════╝██╔════╝\n");
        System.out.print("╚█████╗░██║░░╚═╝██║░░██║██████╔╝█████╗░░╚█████╗░\n");
        System.out.print("░╚═══██╗██║░░██╗██║░░██║██╔══██╗██╔══╝░░░╚═══██╗\n");
        System.out.print("██████╔╝╚█████╔╝╚█████╔╝██║░░██║███████╗██████╔╝\n");
        System.out.print("╚═════╝░░╚════╝░░╚════╝░╚═╝░░╚═╝╚══════╝╚═════╝░\n\n");

        System.out.print(createMenu());

        // defualt options to all players
        System.out.print("\n\n1. Go back\n\n");
    }


    @Override
    public Command getCommand(){

        int selection = getSelection();

        selection = selection == 1 ? 9 : 99;

        // details of command should be different depending on host or guest
        return new GetGameMenuCommand(player, selection);
    }

    @Override
    public int getSelection(){

        Host host = null;
        Guest guest = null;

        if(player.getHost()){
            host = (Host)player;
        }else{
            guest = (Guest)player;
        }
    
        return player.getHost() ? host.getHostSelection(host.getGame().getAcitivePlayer().getName()) : guest.getGuestSelection(guest.getConnection().read());
    }

    public String createMenu(){
        String menu = "";
        if(player.getHost()){
            Host host = (Host)player;

            String active = "ACTIVE PLAYER: " + host.getGame().getAcitivePlayer().getName() + "\t";
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