package command;

import object.Host;
import object.Guest;
import menu.RollMenu;
import menu.ComboMenu;
import menu.Menu;
import menu.ScoresMenu;
import menu.GameMenu;
import menu.LobbyMenu;

public class GetGameMenuCommand implements Command {

    // attributes
    Host host;
    Guest guest;
    boolean isHost;
    int selection;

    // constructor
    public GetGameMenuCommand(Host host, boolean isHost, int selection){
        this.host = host;
        this.isHost = isHost;
        this.selection = selection;
    }
    public GetGameMenuCommand(Guest guest, boolean isHost, int selection){
        this.guest = guest;
        this.isHost = isHost;
        this.selection = selection;
    }

    @Override
    public Menu execute(){
        // details of menu should be different if player is host or guest
        switch(this.selection){
            case 1:
                return isHost ? new RollMenu(this.host, this.isHost) : new RollMenu(this.guest,this. isHost);
            case 2:
                return isHost ? new ComboMenu(this.host, isHost) : new ComboMenu(this.guest, isHost);
            case 3:
                return isHost ? new ScoresMenu(this.host, isHost) : new ScoresMenu(this.guest, isHost);
            case 9:
                return isHost ? new GameMenu(this.host, this.isHost) : new GameMenu(this.guest, this.isHost);
            case 0:
                return new LobbyMenu();
                
        }

        return null;

    }
    
}
