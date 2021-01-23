package command;

import menu.Menu;
import menu.RollMenu;
import object.Host;
import object.Guest;

public class RollCommand implements Command {

    // attributes
    private Host host;
    private Guest guest;
    private boolean isHost;

    // constructor
    public RollCommand(Host host, boolean isHost){
        this.host = host;
        this.isHost = isHost;
    }
    public RollCommand(Guest guest, boolean isHost){
        this.guest = guest;
        this.isHost = isHost;
    }


    @Override
    public Menu execute(){
        return isHost ? new RollMenu(this.host, this.isHost) : new RollMenu(this.guest, this.isHost);
    }
    
}
