package command;

import object.Player;
import menu.RollMenu;
import menu.ComboMenu;
import menu.Menu;
import menu.ScoresMenu;
import menu.GameMenu;
import menu.LobbyMenu;

public class GetGameMenuCommand implements Command {

    // attributes
    private Player player;
    private int selection;

    // constructor
    public GetGameMenuCommand(Player player, int selection){
        this.player = player;
        this.selection = selection;
    }

    @Override
    public Menu execute(){
        // details of menu should be different if player is host or guest
        switch(this.selection){
            case 1:
                return new RollMenu(player);
            case 2:
                return new ComboMenu(player);
            case 3:
                return new ScoresMenu(player);
            case 9:
                return new LobbyMenu();
            case 0:
                return  new GameMenu(player);
        }

        return new GameMenu(player);

    }
    
}
