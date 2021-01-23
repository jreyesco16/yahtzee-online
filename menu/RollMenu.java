package menu;

import object.Host;
import object.Guest;
import command.Command;
import command.ExitCommand;
import command.GetGameMenuCommand;

public class RollMenu extends Menu {

    // attributes
    Host host;
    Guest guest;
    boolean isHost;

    // constructor
    public RollMenu(Host host, boolean isHost){
        this.host = host;
        this.isHost = isHost;
    }
    public RollMenu(Guest guest, boolean isHost){
        this.guest = guest;
        this.isHost = isHost;
    }


    @Override
    public void displayMenu(){
        
        System.out.print("░░░░░░██████╗░░█████╗░██╗░░░░░██╗░░░░░░░\n");
        System.out.print("░░░░░░██╔══██╗██╔══██╗██║░░░░░██║░░░░░░░\n");
        System.out.print("░░░░░░██████╔╝██║░░██║██║░░░░░██║░░░░░░░\n");
        System.out.print("░░░░░░██╔══██╗██║░░██║██║░░░░░██║░░░░░░░\n");
        System.out.print("░░░░░░██║░░██║╚█████╔╝███████╗███████╗░░\n");
        System.out.print("░░░░░░╚═╝░░╚═╝░╚════╝░╚══════╝╚══════╝░░\n\n");

        if(this.isHost){

            // get ative player
            String active = "\n\nACTIVE PLAYER: " + host.getGame().getAcitivePlayer().getName() + "\t";

            // get turns left of active player
            String rolls = "ROLLS: " +  host.getGame().getCup().getRolls() + "\t";

            String round = "ROUND: " + host.getGame().getRound() + "\n";

            // get dice for active player
            String diceString = host.getGame().getCup().getDiceBuilderString() + "   1          2          3          4          5\n\n";

            String menu = active + rolls + round + diceString;

            System.out.print(menu);

            host.printToAllPlayers(menu);



        }else{

            System.out.print(this.guest.getConnection().read());

        }


    }
    
    @Override
    public Command getCommand(){

        int selection = getSelection();

        return this.isHost ? new GetGameMenuCommand(this.host, this.isHost, selection) : new GetGameMenuCommand(this.guest, this.isHost, selection);

    }

    @Override
    public int getSelection(){

        return isHost ? this.host.getHostDiceSelection(host.getGame().getAcitivePlayer().getName()) : this.guest.getGuestDiceSelection(guest.getConnection().read());
    }


}
