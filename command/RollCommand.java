package command;

import menu.GameMenu;
import menu.Menu;
import object.Host;
import object.Player;

public class RollCommand implements Command {

    // attributes
    private Player player;
    private String dicePicks;

    // constructor
    public RollCommand(Player player, String dicePicks){
        this.player = player;
        this.dicePicks = dicePicks;
    }


    @Override
    public Menu execute(){
        // if player is the host then make the turn

        if(player.getHost()){
            Host host = (Host)player;
            host.getGame().getCup().rerollDice(dicePicks);
        }

        return new GameMenu(player);
    }
    
}
