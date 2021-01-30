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
        
        System.out.print("░█████╗░░█████╗░███╗░░░███╗██████╗░░█████╗░░██████╗\n");
        System.out.print("██╔══██╗██╔══██╗████╗░████║██╔══██╗██╔══██╗██╔════╝\n");
        System.out.print("██║░░╚═╝██║░░██║██╔████╔██║██████╦╝██║░░██║╚█████╗░\n");
        System.out.print("██║░░██╗██║░░██║██║╚██╔╝██║██╔══██╗██║░░██║░╚═══██╗\n");
        System.out.print("╚█████╔╝╚█████╔╝██║░╚═╝░██║██████╦╝╚█████╔╝██████╔╝\n");
        System.out.print("░╚════╝░░╚════╝░╚═╝░░░░░╚═╝╚═════╝░░╚════╝░╚═════╝░\n");

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

        if(player.getHost()){
            Host host = (Host)player;
            selection = host.getHostSelection(host.getGame().getAcitivePlayer().getName());
        }else{
            Guest guest = (Guest)player;
            selection = guest.getGuestSelection(guest.getConnection().read());

        }

        return selection;
    }

    public String createMenu(){
        String menu = "";
        if(player.getHost()){
            Host host = (Host)player;

            String active = "\n\nACTIVE PLAYER: " + host.getGame().getAcitivePlayer().getName() + "\t";
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
