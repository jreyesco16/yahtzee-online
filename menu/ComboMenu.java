package menu;

import object.Host;
import command.ComboCommand;
import command.Command;
import object.Guest;

public class ComboMenu extends Menu {

    // attributes
    private Host host;
    private Guest guest;
    private boolean isHost;

    // constructor
    public ComboMenu(Host host, boolean isHost){
        this.host = host;
        this.isHost = isHost;
    }
    public ComboMenu(Guest guest, boolean isHost){
        this.guest = guest;
        this.isHost = isHost;
    }

    @Override
    public void displayMenu(){
        
        System.out.print("░█████╗░░█████╗░███╗░░░███╗██████╗░░█████╗░░██████╗\n");
        System.out.print("██╔══██╗██╔══██╗████╗░████║██╔══██╗██╔══██╗██╔════╝\n");
        System.out.print("██║░░╚═╝██║░░██║██╔████╔██║██████╦╝██║░░██║╚█████╗░\n");
        System.out.print("██║░░██╗██║░░██║██║╚██╔╝██║██╔══██╗██║░░██║░╚═══██╗\n");
        System.out.print("╚█████╔╝╚█████╔╝██║░╚═╝░██║██████╦╝╚█████╔╝██████╔╝\n");
        System.out.print("░╚════╝░░╚════╝░╚═╝░░░░░╚═╝╚═════╝░░╚════╝░╚═════╝░\n");


        if(this.isHost){
            // get all parts of menu
            String active = "\n\nACTIVE PLAYER: " + host.getGame().getAcitivePlayer().getName() + "\t";
            String rolls = "ROLLS: " + host.getGame().getCup().getRolls() + "\t";
            String round = "ROUND: " + host.getGame().getRound() + "\n";

            String combos = this.host.getGame().getCombosString() + "\n\n";

            // combine to make menu
            String menu = active + rolls + round + combos;

            System.out.print(menu);

            host.printToAllPlayers(menu);
        }else{
            System.out.print(this.guest.getConnection().read());
        }
    }

    @Override
    public Command getCommand(){

        int selection = getSelection();

        return isHost ? new ComboCommand(this.host, this.isHost, selection) : new ComboCommand(this.guest, this.isHost, selection);
    }

    @Override
    public int getSelection(){

        return isHost ? host.getHostSelection(host.getGame().getAcitivePlayer().getName()) : guest.getGuestSelection(guest.getConnection().read());
    }
    
}
