package menu;

import object.Guest;
import object.Host;
import object.Player;
import command.ComboCommand;
import command.Command;

public class ComboMenu extends Menu {

    // attributes
    private Player player;

    // constructor
    public ComboMenu(Player player){
        this.player = player;
    }

    @Override
    public void displayMenu(){
        // AVAILABLE COMBOS
        System.out.println("\n\n\n");
        System.out.print("\t░░░█████╗░██╗░░░██╗░█████╗░██╗██╗░░░░░░█████╗░██████╗░██╗░░░░░███████╗░░\n");
        System.out.print("\t░░██╔══██╗██║░░░██║██╔══██╗██║██║░░░░░██╔══██╗██╔══██╗██║░░░░░██╔════╝░░\n");
        System.out.print("\t░░███████║╚██╗░██╔╝███████║██║██║░░░░░███████║██████╦╝██║░░░░░█████╗░░░░\n");
        System.out.print("\t░░██╔══██║░╚████╔╝░██╔══██║██║██║░░░░░██╔══██║██╔══██╗██║░░░░░██╔══╝░░░░\n");
        System.out.print("\t░░██║░░██║░░╚██╔╝░░██║░░██║██║███████╗██║░░██║██████╦╝███████╗███████╗░░\n");
        System.out.print("\t░░╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░╚═╝╚═╝╚══════╝╚═╝░░╚═╝╚═════╝░╚══════╝╚══════╝░░\n");
        System.out.print("\t\t░░░█████╗░░█████╗░███╗░░░███╗██████╗░░█████╗░░██████╗░░\n");
        System.out.print("\t\t░░██╔══██╗██╔══██╗████╗░████║██╔══██╗██╔══██╗██╔════╝░░\n");
        System.out.print("\t\t░░██║░░╚═╝██║░░██║██╔████╔██║██████╦╝██║░░██║╚█████╗░░░\n");
        System.out.print("\t\t░░██║░░██╗██║░░██║██║╚██╔╝██║██╔══██╗██║░░██║░╚═══██╗░░\n");
        System.out.print("\t\t░░╚█████╔╝╚█████╔╝██║░╚═╝░██║██████╦╝╚█████╔╝██████╔╝░░\n");
        System.out.print("\t\t░░░╚════╝░░╚════╝░╚═╝░░░░░╚═╝╚═════╝░░╚════╝░╚═════╝░░░\n");

        System.out.print(createMenu());
    }

    @Override
    public Command getCommand(){
        int selection = getSelection();

        return new ComboCommand(player, selection);
    }

    @Override
    public int getSelection(){

        int selection = 0;

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

            String active = "\n\n\t\tACTIVE PLAYER: " + host.getGame().getActivePlayer().getName() + "\t";
            String rolls = "ROLLS: " + host.getGame().getCup().getRolls() + "\t";
            String round = "ROUND: " + host.getGame().getRound() + "\n";

            String combos = host.getGame().getCombosString() + "\n\n";

            // combine to make menu
            menu = active + rolls + round + combos;

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
