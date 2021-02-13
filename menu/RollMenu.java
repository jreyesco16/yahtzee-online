package menu;

import object.Host;
import object.Player;
import object.Guest;
import command.Command;
import command.RollCommand;

public class RollMenu extends Menu {

    // attributes
    private Player player;
    private String dicePicks;
    

    // constructor
    public RollMenu(Player player){
        this.player = player;
    }


    @Override
    public void displayMenu(){
        // ROLL DICE ??? (maybe will choose something different)
        System.out.println("\n\n\n");
        System.out.print("\t░░░██████╗░░█████╗░██╗░░░░░██╗░░░░░░░██████╗░██╗░█████╗░███████╗░░\n");
        System.out.print("\t░░░██╔══██╗██╔══██╗██║░░░░░██║░░░░░░░██╔══██╗██║██╔══██╗██╔════╝░░\n");
        System.out.print("\t░░░██████╔╝██║░░██║██║░░░░░██║░░░░░░░██║░░██║██║██║░░╚═╝█████╗░░░░\n");
        System.out.print("\t░░░██╔══██╗██║░░██║██║░░░░░██║░░░░░░░██║░░██║██║██║░░██╗██╔══╝░░░░\n");
        System.out.print("\t░░░██║░░██║╚█████╔╝███████╗███████╗░░██████╔╝██║╚█████╔╝███████╗░░\n");
        System.out.print("\t░░░╚═╝░░╚═╝░╚════╝░╚══════╝╚══════╝░░╚═════╝░╚═╝░╚════╝░╚══════╝░░\n\n");

        // varies depending on player type, and game type
        System.out.print(createMenu());
    }
    
    @Override
    public Command getCommand(){

        getSelection();

        return new RollCommand(player, dicePicks);
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

        dicePicks = player.getHost() ? host.getHostDiceSelection(activePlayer) : guest.getGuestDiceSelection(activePlayer);

        return 0;
    }

    public String createMenu(){
        String menu = "";
        if(player.getHost()){
            Host host = (Host)player;

            String active = "\n\n\t\tACTIVE PLAYER: " + host.getGame().getActivePlayer().getName() + "\t";
            String rolls = "ROLLS: " +  host.getGame().getCup().getRolls() + "\t";
            String round = "ROUND: " + host.getGame().getRound() + "\n";
            String diceString = host.getGame().getCup().getDiceBuilderString() + "\t\t   1          2          3          4          5\n\n";

            menu = active + rolls + round + diceString;

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