package command;

import menu.GameMenu;
import menu.EndGameMenu;
import menu.Menu;
import object.Guest;
import object.Host;

public class ComboCommand implements Command {

    // attributes
    private Host host;
    private Guest guest;
    private boolean isHost;
    int selection;
    

    // constructor
    public ComboCommand(Host host, boolean isHost, int selection) {
        this.host = host;
        this.isHost = isHost;
        this.selection = selection;
    }
    public ComboCommand(Guest guest, boolean isHost, int selection){
        this.guest = guest;
        this.isHost = isHost;
        this.selection = selection;
    }

    @Override
    public Menu execute() {

        if(this.isHost){
            // take the turn
            selectCombo(this.selection);

            // check if game is over
            if(this.host.getGame().getRound() == 14){
                this.host.printToAllPlayers("gameover");
                // inform the guests that the game is over
                return new EndGameMenu(this.host, this.isHost, 1);
            }

            this.host.printToAllPlayers("continue");
        }else{
            // check if the game is over
            if("gameover".equals(guest.getConnection().read())){
                return new EndGameMenu(this.guest, this.isHost, 1);
            }
        }

        return isHost ? new GameMenu(this.host, this.isHost) : new GameMenu(this.guest, this.isHost);
    }

    // change card based on player selection
    public void selectCombo(int selection){
        int num = 0;
        switch(this.selection){
            case 1:
                num = this.host.getGame().getCup().calculateAces();
                this.host.getGame().getAcitivePlayer().getCard().setAces(num);
                this.host.getGame().getAcitivePlayer().getCard().setAcesBool(true);
                break;
            case 2:
                num = this.host.getGame().getCup().calculateTwos();
                this.host.getGame().getAcitivePlayer().getCard().setTwos(num);
                this.host.getGame().getAcitivePlayer().getCard().setTwosBool(true);
                break;
            case 3:
                num = this.host.getGame().getCup().calculateThrees();
                this.host.getGame().getAcitivePlayer().getCard().setThrees(num);
                this.host.getGame().getAcitivePlayer().getCard().setThreesBool(true);
                break;
            case 4:
            num = this.host.getGame().getCup().calculateFours();
                this.host.getGame().getAcitivePlayer().getCard().setFours(num);
                this.host.getGame().getAcitivePlayer().getCard().setFoursBool(true);
                break;
            case 5:
                num = this.host.getGame().getCup().calculateFives();
                this.host.getGame().getAcitivePlayer().getCard().setFives(num);
                this.host.getGame().getAcitivePlayer().getCard().setFivesBool(true);
                break;
            case 6:
            num = this.host.getGame().getCup().calculateSixes();
                this.host.getGame().getAcitivePlayer().getCard().setSixes(num);
                this.host.getGame().getAcitivePlayer().getCard().setSixesBool(true);
                break;
            case 7:
                num = this.host.getGame().getCup().calculateThreeKind();
                this.host.getGame().getAcitivePlayer().getCard().setThreeKind(num);
                this.host.getGame().getAcitivePlayer().getCard().setThreeKindBool(true);
                break;
            case 8:
            num = this.host.getGame().getCup().calculateFourKind();
                this.host.getGame().getAcitivePlayer().getCard().setFourKind(num);
                this.host.getGame().getAcitivePlayer().getCard().setFourKindBool(true);
                break;
            case 9:
                num = this.host.getGame().getCup().calculateFullHouse();
                this.host.getGame().getAcitivePlayer().getCard().setFullHouse(num);
                this.host.getGame().getAcitivePlayer().getCard().setFullHouseBool(true);
                break;
            case 10:
                num = this.host.getGame().getCup().calculateSmallStraight();
                this.host.getGame().getAcitivePlayer().getCard().setSmallStraight(num);
                this.host.getGame().getAcitivePlayer().getCard().setSmallStraightBool(true);
                break;
            case 11:
                num = this.host.getGame().getCup().calculateLargeStraight();
                this.host.getGame().getAcitivePlayer().getCard().setLargeStraight(num);
                this.host.getGame().getAcitivePlayer().getCard().setLargeStraightBool(true);
                break;
            case 12:
                num = this.host.getGame().getCup().calculateYahtzee();
                this.host.getGame().getAcitivePlayer().getCard().setYahtzee(num);
                this.host.getGame().getAcitivePlayer().getCard().setYahtzeeBool(true);
                break;
            case 13:
                num = this.host.getGame().getCup().calculateChance();
                this.host.getGame().getAcitivePlayer().getCard().setChance(num);
                this.host.getGame().getAcitivePlayer().getCard().setChanceBool(true);
                break;
        }
        // reset cup
        this.host.getGame().getCup().resetCup();
        // change player
        this.host.getGame().switchActivePlayer();
    }
    
}
