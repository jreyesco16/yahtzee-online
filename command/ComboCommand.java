package command;

import menu.GameMenu;
import menu.EndGameMenu;
import menu.Menu;
import object.Guest;
import object.Host;
import object.Player;

public class ComboCommand implements Command {

    // attributes
    private Player player;
    private int selection;
    

    // constructor
    public ComboCommand(Player player, int selection) {
        this.player = player;
        this.selection = selection;
    }

    @Override
    public Menu execute() {

        if(player.getHost()){

            Host host = (Host)player;
            // take the turn
            selectCombo(selection);

            // check if game is over
            if(host.getGame().getRound() == 14){
                if(host.getGame().getOnline()){
                    host.printToAllPlayers("gameover");
                }
                // inform the guests that the game is over
                return new EndGameMenu(player);
            }

            if(host.getGame().getOnline()){
                host.printToAllPlayers("continue");
            }
            
        }else{

            Guest guest = (Guest)player;
            // check if the game is over
            if("gameover".equals(guest.getConnection().read())){
                return new EndGameMenu(player);
            }
        }

        return new GameMenu(player);
    }

    // change card based on player selection
    public void selectCombo(int selection){
        int num = 0;


        if(selection <= 0 || 13 < selection){
            return;
        }

        Host host = (Host)player;

        switch(this.selection){
            case 1:
                num = host.getGame().getCup().calculateAces();
                host.getGame().getAcitivePlayer().getCard().setAces(num);
                host.getGame().getAcitivePlayer().getCard().setAcesBool(true);
                break;
            case 2:
                num = host.getGame().getCup().calculateTwos();
                host.getGame().getAcitivePlayer().getCard().setTwos(num);
                host.getGame().getAcitivePlayer().getCard().setTwosBool(true);
                break;
            case 3:
                num = host.getGame().getCup().calculateThrees();
                host.getGame().getAcitivePlayer().getCard().setThrees(num);
                host.getGame().getAcitivePlayer().getCard().setThreesBool(true);
                break;
            case 4:
            num = host.getGame().getCup().calculateFours();
                host.getGame().getAcitivePlayer().getCard().setFours(num);
                host.getGame().getAcitivePlayer().getCard().setFoursBool(true);
                break;
            case 5:
                num = host.getGame().getCup().calculateFives();
                host.getGame().getAcitivePlayer().getCard().setFives(num);
                host.getGame().getAcitivePlayer().getCard().setFivesBool(true);
                break;
            case 6:
            num = host.getGame().getCup().calculateSixes();
                host.getGame().getAcitivePlayer().getCard().setSixes(num);
                host.getGame().getAcitivePlayer().getCard().setSixesBool(true);
                break;
            case 7:
                num = host.getGame().getCup().calculateThreeKind();
                host.getGame().getAcitivePlayer().getCard().setThreeKind(num);
                host.getGame().getAcitivePlayer().getCard().setThreeKindBool(true);
                break;
            case 8:
                num = host.getGame().getCup().calculateFourKind();
                host.getGame().getAcitivePlayer().getCard().setFourKind(num);
                host.getGame().getAcitivePlayer().getCard().setFourKindBool(true);
                break;
            case 9:
                num = host.getGame().getCup().calculateFullHouse();
                host.getGame().getAcitivePlayer().getCard().setFullHouse(num);
                host.getGame().getAcitivePlayer().getCard().setFullHouseBool(true);
                break;
            case 10:
                num = host.getGame().getCup().calculateSmallStraight();
                host.getGame().getAcitivePlayer().getCard().setSmallStraight(num);
                host.getGame().getAcitivePlayer().getCard().setSmallStraightBool(true);
                break;
            case 11:
                num = host.getGame().getCup().calculateLargeStraight();
                host.getGame().getAcitivePlayer().getCard().setLargeStraight(num);
                host.getGame().getAcitivePlayer().getCard().setLargeStraightBool(true);
                break;
            case 12:
                num = host.getGame().getCup().calculateYahtzee();
                host.getGame().getAcitivePlayer().getCard().setYahtzee(num);
                host.getGame().getAcitivePlayer().getCard().setYahtzeeBool(true);
                break;
            case 13:
                num = host.getGame().getCup().calculateChance();
                host.getGame().getAcitivePlayer().getCard().setChance(num);
                host.getGame().getAcitivePlayer().getCard().setChanceBool(true);
                break;
        }
        // reset cup
        host.getGame().getCup().resetCup();
        // change player
        host.getGame().switchActivePlayer();
    }
    
}
