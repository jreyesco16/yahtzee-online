package menu;

import command.Command;
import command.GetGameMenuCommand;
import object.Guest;
import object.Host;
import object.Player;

public class GameMenu extends Menu {

    // attributes
    private Player player;

    // constructor
    public GameMenu(Player player) {
        this.player = player;
    }

    // show how's turn is it, show eligible options to players
    @Override
    public void displayMenu() {

        System.out.print("██╗░░░██╗░█████╗░██╗░░██╗████████╗███████╗███████╗███████╗\n");
        System.out.print("╚██╗░██╔╝██╔══██╗██║░░██║╚══██╔══╝╚════██║██╔════╝██╔════╝\n");
        System.out.print("░╚████╔╝░███████║███████║░░░██║░░░░░███╔═╝█████╗░░█████╗░░\n");
        System.out.print("░░╚██╔╝░░██╔══██║██╔══██║░░░██║░░░██╔══╝░░██╔══╝░░██╔══╝░░\n");
        System.out.print("░░░██║░░░██║░░██║██║░░██║░░░██║░░░███████╗███████╗███████╗\n");
        System.out.print("░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░╚══════╝╚══════╝╚══════╝\n");

        // varies depending on player type, and game type
        System.out.print(createMenu());

        // defualt options to all players(although only active player can make selection)
        System.out.print("\n\n\t\t\t\t1. Roll Dice\n");
        System.out.print("\t\t\t\t2. Select Combo\n");
        System.out.print("\t\t\t\t3. View Scores\n");
        System.out.print("\t\t\t\t0. Exit\n\n");
    }

    @Override
    public Command getCommand(){

        // selection should vary depending is the game is online or local
        
        int selection = player.getHost() ? getSelection() : player.getSelectionFromTerminal();

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
            String round = "ROUND: " + host.getGame().getRound() + "\n";
            String scoreBoard = host.getGame().getScoreBoard();
            String diceString = host.getGame().getCup().getDiceBuilderString();
            String rolls = "ROLLS: " + host.getGame().getCup().getRolls() + "\t";

            menu = "\n\n" + scoreBoard + active + rolls + round + diceString;

            if(host.getGame().getOnline()){
                host.printToAllPlayers(menu);
            }
        }else{
            Guest guest = (Guest)player;
            menu = guest.getConnection().read();
        }
        return menu;
    }

    // getters + setters
    
}