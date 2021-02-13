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
        System.out.println("\n\n\n");

        // varies depending on player type, and game type
        System.out.print(createMenu());

        // defualt options to all players(although only active player can make selection)
        System.out.print("\n\n\t\t\t\t\t1. Roll Dice\n");
        System.out.print("\t\t\t\t\t2. Select Combo\n");
        System.out.print("\t\t\t\t\t3. View Scores\n");
        System.out.print("\t\t\t\t\t0. Exit\n\n");
    }

    @Override
    public Command getCommand(){
        
        int selection = verifySelection(getSelection());

        return new GetGameMenuCommand(player, selection);
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

            String header = "";
        

            Host host = (Host)player;

            if(host.getGame().getOnline()){

                header ="\t██╗░░░██╗░█████╗░██╗░░██╗████████╗███████╗███████╗███████╗░░░░░█████╗░███╗░░██╗██╗░░░░░██╗███╗░░██╗███████╗\n" + 
                        "\t╚██╗░██╔╝██╔══██╗██║░░██║╚══██╔══╝╚════██║██╔════╝██╔════╝░░░░██╔══██╗████╗░██║██║░░░░░██║████╗░██║██╔════╝\n" +
                        "\t░╚████╔╝░███████║███████║░░░██║░░░░░███╔═╝█████╗░░█████╗░░░░░░██║░░██║██╔██╗██║██║░░░░░██║██╔██╗██║█████╗░░\n" +
                        "\t░░╚██╔╝░░██╔══██║██╔══██║░░░██║░░░██╔══╝░░██╔══╝░░██╔══╝░░░░░░██║░░██║██║╚████║██║░░░░░██║██║╚████║██╔══╝░░\n" +
                        "\t░░░██║░░░██║░░██║██║░░██║░░░██║░░░███████╗███████╗███████╗░░░░╚█████╔╝██║░╚███║███████╗██║██║░╚███║███████╗\n" +
                        "\t░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░╚══════╝╚══════╝╚══════╝░░░░░╚════╝░╚═╝░░╚══╝╚══════╝╚═╝╚═╝░░╚══╝╚══════╝\n";

            }else{
                header ="\t██╗░░░██╗░█████╗░██╗░░██╗████████╗███████╗███████╗███████╗░░██╗░░░░░░█████╗░░█████╗░░█████╗░██╗░░░░░\n" +
                        "\t╚██╗░██╔╝██╔══██╗██║░░██║╚══██╔══╝╚════██║██╔════╝██╔════╝░░██║░░░░░██╔══██╗██╔══██╗██╔══██╗██║░░░░░\n" + 
                        "\t░╚████╔╝░███████║███████║░░░██║░░░░░███╔═╝█████╗░░█████╗░░░░██║░░░░░██║░░██║██║░░╚═╝███████║██║░░░░░\n" + 
                        "\t░░╚██╔╝░░██╔══██║██╔══██║░░░██║░░░██╔══╝░░██╔══╝░░██╔══╝░░░░██║░░░░░██║░░██║██║░░██╗██╔══██║██║░░░░░\n" +
                        "\t░░░██║░░░██║░░██║██║░░██║░░░██║░░░███████╗███████╗███████╗░░███████╗╚█████╔╝╚█████╔╝██║░░██║███████╗\n" +
                        "\t░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░╚══════╝╚══════╝╚══════╝░░╚══════╝░╚════╝░░╚════╝░╚═╝░░╚═╝╚══════╝\n";
            }

            String active = "\t\tACTIVE PLAYER: " + host.getGame().getActivePlayer().getName() + "\t";
            String round = "ROUND: " + host.getGame().getRound() + "\n";
            String scoreBoard = host.getGame().getScoreBoard();
            String diceString = host.getGame().getCup().getDiceBuilderString();
            String rolls = "ROLLS: " + host.getGame().getCup().getRolls() + "\t";

            menu = header + "\n\n" + scoreBoard + active + rolls + round + diceString;

            if(host.getGame().getOnline()){
                host.printToAllPlayers(menu);
            }
        }else{
            Guest guest = (Guest)player;
            menu = guest.getConnection().read();
        }
        return menu;
    }


    // verify if selection is eligible 
    public int verifySelection(int selection){

        int verifiedSelection = selection;

        Host host = null;
        Guest guest = null;


        if(player.getHost()){
            host = (Host)player;

            if(selection == 0){
                verifiedSelection = 9;
            }else if(host.getGame().getCup().getRolls() == 0 && selection == 1){
                verifiedSelection = 0;
            }
            // if online game
            if(host.getGame().getOnline()){
                host.printToAllPlayers(Integer.toString(verifiedSelection));
            }
        }else{
            guest = (Guest)player;
        
            verifiedSelection = Integer.parseInt(guest.getConnection().read());
        }
        

        return verifiedSelection;

    }

    // getters + setters
    
}