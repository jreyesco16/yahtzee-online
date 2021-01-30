package menu;

import object.Host;
import object.Player;
import object.Guest;
import command.Command;
import command.RollCommand;

public class RollMenu extends Menu {

    // attributes
    private Player player;
    private boolean online;
    private String dicePicks;
    

    // constructor
    public RollMenu(Player player){
        this.player = player;
    }


    @Override
    public void displayMenu(){
        
        System.out.print("░░░░░░██████╗░░█████╗░██╗░░░░░██╗░░░░░░░\n");
        System.out.print("░░░░░░██╔══██╗██╔══██╗██║░░░░░██║░░░░░░░\n");
        System.out.print("░░░░░░██████╔╝██║░░██║██║░░░░░██║░░░░░░░\n");
        System.out.print("░░░░░░██╔══██╗██║░░██║██║░░░░░██║░░░░░░░\n");
        System.out.print("░░░░░░██║░░██║╚█████╔╝███████╗███████╗░░\n");
        System.out.print("░░░░░░╚═╝░░╚═╝░╚════╝░╚══════╝╚══════╝░░\n\n");

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

        if(player.getHost()){
            host = (Host)player;
        }else{
            guest = (Guest)player;
        }

        dicePicks = player.getHost() ? host.getHostDiceSelection(host.getGame().getAcitivePlayer().getName()) : guest.getGuestDiceSelection(guest.getConnection().read());

        return 0;
    }

    public String createMenu(){
        String menu = "";
        if(player.getHost()){
            Host host = (Host)player;

            String active = "\n\nACTIVE PLAYER: " + host.getGame().getAcitivePlayer().getName() + "\t";
            String rolls = "ROLLS: " +  host.getGame().getCup().getRolls() + "\t";
            String round = "ROUND: " + host.getGame().getRound() + "\n";
            String diceString = host.getGame().getCup().getDiceBuilderString() + "   1          2          3          4          5\n\n";

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
