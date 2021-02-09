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

        boolean success = false;

        switch(this.selection){
            case 1:
                if(host.getGame().getActivePlayer().getCard().getAcesBool() == false){
                    num = host.getGame().getCup().calculateAces();
                    host.getGame().getActivePlayer().getCard().setAces(num);
                    host.getGame().getActivePlayer().getCard().setAcesBool(true);
                    success = true;
                }else{
                    // do nothing
                }
                break;
            case 2:
                if(host.getGame().getActivePlayer().getCard().getTwosBool() == false){
                    num = host.getGame().getCup().calculateTwos();
                    host.getGame().getActivePlayer().getCard().setTwos(num);
                    host.getGame().getActivePlayer().getCard().setTwosBool(true);
                    success = true;
                }else{
                    //do nothing
                }
                break;
            case 3:
                if(host.getGame().getActivePlayer().getCard().getThreesBool() == false){
                    num = host.getGame().getCup().calculateThrees();
                    host.getGame().getActivePlayer().getCard().setThrees(num);
                    host.getGame().getActivePlayer().getCard().setThreesBool(true);
                    success = true;
                }else{
                    // do nothing
                }
                break;
            case 4:
                if(host.getGame().getActivePlayer().getCard().getFoursBool() == false){
                    num = host.getGame().getCup().calculateFours();
                    host.getGame().getActivePlayer().getCard().setFours(num);
                    host.getGame().getActivePlayer().getCard().setFoursBool(true);
                    success = true;
                }else{
                    // do nothing
                }
                break;
            case 5:
                if(host.getGame().getActivePlayer().getCard().getFivesBool() == false){
                    num = host.getGame().getCup().calculateFives();
                    host.getGame().getActivePlayer().getCard().setFives(num);
                    host.getGame().getActivePlayer().getCard().setFivesBool(true);
                    success = true;
                }else{
                    // do nothing
                }
                break;
            case 6:
                if(host.getGame().getActivePlayer().getCard().getSixesBool() == false){
                    num = host.getGame().getCup().calculateSixes();
                    host.getGame().getActivePlayer().getCard().setSixes(num);
                    host.getGame().getActivePlayer().getCard().setSixesBool(true);
                    success = true;
                }else{
                    // do nothing
                }
                break;
            case 7:
                if(host.getGame().getActivePlayer().getCard().getThreeKindBool() == false){
                    num = host.getGame().getCup().calculateThreeKind();
                    host.getGame().getActivePlayer().getCard().setThreeKind(num);
                    host.getGame().getActivePlayer().getCard().setThreeKindBool(true);
                    success = true;
                }else{
                    // do nothing
                }
                break;
            case 8:
                if(host.getGame().getActivePlayer().getCard().getFourKindBool() == false){
                    num = host.getGame().getCup().calculateFourKind();
                    host.getGame().getActivePlayer().getCard().setFourKind(num);
                    host.getGame().getActivePlayer().getCard().setFourKindBool(true);
                    success = true;
                }else{
                    // do nothing
                }
                break;
            case 9:
                if(host.getGame().getActivePlayer().getCard().getFullHouseBool() == false){
                    num = host.getGame().getCup().calculateFullHouse();
                    host.getGame().getActivePlayer().getCard().setFullHouse(num);
                    host.getGame().getActivePlayer().getCard().setFullHouseBool(true);
                    success = true;
                }else{
                    // do nothing
                }
                break;
            case 10:
                if(host.getGame().getActivePlayer().getCard().getSmallStraightBool() == false){
                    num = host.getGame().getCup().calculateSmallStraight();
                    host.getGame().getActivePlayer().getCard().setSmallStraight(num);
                    host.getGame().getActivePlayer().getCard().setSmallStraightBool(true);
                    success = true;
                }else{
                    // do nothing
                }
                break;
            case 11:
                if(host.getGame().getActivePlayer().getCard().getLargeStraightBool() == false){
                    num = host.getGame().getCup().calculateLargeStraight();
                    host.getGame().getActivePlayer().getCard().setLargeStraight(num);
                    host.getGame().getActivePlayer().getCard().setLargeStraightBool(true);
                    success = true;
                }else{
                    // do nothing
                }
                break;
            case 12:
                if(host.getGame().getActivePlayer().getCard().getYahtzeeBool() == false){
                    num = host.getGame().getCup().calculateYahtzee();
                    host.getGame().getActivePlayer().getCard().setYahtzee(num);
                    host.getGame().getActivePlayer().getCard().setYahtzeeBool(true);
                    success = true;
                }else{
                    // do nothing
                }
                break;
            case 13:
                if(host.getGame().getActivePlayer().getCard().getChanceBool() == false){
                    num = host.getGame().getCup().calculateChance();
                    host.getGame().getActivePlayer().getCard().setChance(num);
                    host.getGame().getActivePlayer().getCard().setChanceBool(true);
                    success = true;
                }else{
                    // do nothing
                }
                break;
        }
        if(success == true){
            // reset cup
            host.getGame().getCup().resetCup();
            // change player
            host.getGame().switchActivePlayer();
        }
        
    }
    
}
