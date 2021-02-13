package object;

import java.util.ArrayList;

public class Game {

    // attributes
    private ArrayList<Player> players;
    private Cup cup;
    private int activeIndex;
    private int round;
    private boolean online;

    // constructors
    public Game(ArrayList<Player> players, Cup cup, boolean online){
        this.players = players;
        this.cup = cup;
        this.online = online;
        this.activeIndex = 0;
        this.round = 1;
    }

    // get active player
    public Player getActivePlayer(){
        return this.players.get(this.activeIndex);
    }

    // switch next active player
    public void switchActivePlayer(){
        // reached end of players list
        if(this.activeIndex == this.players.size() - 1){
            this.activeIndex = 0;
            this.round++;
        }else{
            this.activeIndex++;
        }
    }

    // create score card for players
    public String getScoreBoard(){

        ArrayList<Player> sorted = sortedList();

        // ArrayList<Player> sorted = players;

        String scoreBoard = "\t\t\t\t----------SCORE BOARD----------\n";

        for(int i = 0; i < players.size(); i++){
            scoreBoard = scoreBoard + "\t\t\t\t" + (i+1) + ". " + sorted.get(i).getName() + ": " + sorted.get(i).getCard().getGrandTotal() + "\t\n" + "\t\t\t\t-------------------------------\n";
        }

        return scoreBoard + "\n\n";
    }

    // create string to get all player scores
    public String getScoresString(){
        String scores = "\t--------UPPER SELECTION-------- \t"; for(Player p: players){ scores += String.format("%-8s  ", p.getName()+":"); };
        scores += "\n\tAces:                               \t"; for(Player p: players){ scores += String.format("%-8d  ", p.getCard().getAces()); };
        scores += "\n\tTwos:                               \t"; for(Player p: players){ scores += String.format("%-8d  ", p.getCard().getTwos()); };
        scores += "\n\tThrees:                             \t"; for(Player p: players){ scores += String.format("%-8d  ", p.getCard().getThrees()); };
        scores += "\n\tFours:                              \t"; for(Player p: players){ scores += String.format("%-8d  ", p.getCard().getFours()); };
        scores += "\n\tFives:                              \t"; for(Player p: players){ scores += String.format("%-8d  ", p.getCard().getFives()); };
        scores += "\n\tSixes:                              \t"; for(Player p: players){ scores += String.format("%-8d  ", p.getCard().getSixes()); };
        scores += "\n\tTOTAL SCORE --->:                   \t"; for(Player p: players){ scores += String.format("%-8d  ", p.getCard().getTotalScore()); };
        scores += "\n\tBONUS:                              \t"; for(Player p: players){ scores += String.format("%-8d  ", p.getCard().getBonus()); };
        scores += "\n\tTOTAL       --->:                   \t"; for(Player p: players){ scores += String.format("%-8d  ", p.getCard().getTotal()); };
		scores += "\n\t--------LOWER SELECTION--------";
        scores += "\n\t3 of a kind:                        \t"; for(Player p: players){ scores += String.format("%-8d  ", p.getCard().getThreeKind()); };
        scores += "\n\t4 of a kind:                        \t"; for(Player p: players){ scores += String.format("%-8d  ", p.getCard().getFourKind()); };
        scores += "\n\tFull House:                         \t"; for(Player p: players){ scores += String.format("%-8d  ", p.getCard().getFullHouse()); };
        scores += "\n\tSm Straight:                        \t"; for(Player p: players){ scores += String.format("%-8d  ", p.getCard().getSmallStraight()); };
        scores += "\n\tLg Straight:                        \t"; for(Player p: players){ scores += String.format("%-8d  ", p.getCard().getLargeStraight()); };
        scores += "\n\tYAHTZEE:                            \t"; for(Player p: players){ scores += String.format("%-8d  ", p.getCard().getYahtzee()); };
        scores += "\n\tChance:                             \t"; for(Player p: players){ scores += String.format("%-8d  ", p.getCard().getChance()); };
        scores += "\n\t    YAHTZEE :                       \t"; for(Player p: players){ scores += String.format("%-8d  ", p.getCard().getYahzeeBonus()); };
        scores += "\n\t     BONUS";
        scores += "\n\n\tTotal Upper --->:                   \t"; for(Player p: players){ scores += String.format("%-8d  ", p.getCard().getTotalUpperSelection()); };
        scores += "\n\tTotal Lower --->:                   \t"; for(Player p: players){ scores += String.format("%-8d  ", p.getCard().getTotalLowerSelection()); };
        scores += "\n\tGRAND TOTAL --->:                   \t"; for(Player p: players){ scores += String.format("%-8d  ", p.getCard().getGrandTotal()); };

        return scores;
    }

    // get game winner
    public String getWinner(){
        String winner = "";
        int maxScore = 0;

        for(Player p : players){
            if(maxScore < p.getCard().getGrandTotal()){
                maxScore = p.getCard().getGrandTotal();
                winner = p.getName();
            }
        }
        return winner;
    }

    public ArrayList<Player> sortedList(){

        ArrayList<Player> sorted = new ArrayList<Player>();

        for(Player p: players){
            sorted.add(p);
        }

        int index = 0;
        Player p = null;

        int max = 0;
        for(int i = 0; i < sorted.size(); i++){
            max = 0;
            index = i;
            for(int j = i; j < sorted.size(); j++){
                if(sorted.get(j).getCard().getGrandTotal() >= max){
                    max = sorted.get(j).getCard().getGrandTotal();
                    index = j;
                }
            }
            
            p = sorted.get(i);

            sorted.set(i, sorted.get(index));
            sorted.set(index, p);
        }

        return sorted;
    }

    // create string to get all player combos
    public String getCombosString(){
        String combos = "\n\n";

        // combos ACES & TWOS

        if(!getActivePlayer().getCard().getAcesBool() && !getActivePlayer().getCard().getTwosBool()){
            combos += "\t1. Aces:    " + getCup().calculateAces() + "\t\t\t\t2. Twos:    " + getCup().calculateTwos();
        }else if(!getActivePlayer().getCard().getAcesBool()){
            combos += "\t1. Aces:    " + getCup().calculateTwos();
        }else if(!getActivePlayer().getCard().getTwosBool()){
            combos += "\t\t\t\t\t\t2. Twos:    " + getCup().calculateTwos();
        }

        combos += "\n\n";

        if(!getActivePlayer().getCard().getThreesBool() && !getActivePlayer().getCard().getFoursBool()){
            combos += "\t3. Threes:    " + getCup().calculateThrees() + "   \t\t\t4. Fours:    " + getCup().calculateFours();
        }else if(!getActivePlayer().getCard().getThreesBool()){
            combos += "\t3. Threes:    " + getCup().calculateThrees();
        }else if(!getActivePlayer().getCard().getFoursBool()){
            combos += "\t\t\t\t\t\t4. Fours:    " + getCup().calculateFours();
        }

        combos += "\n\n";

        if(!getActivePlayer().getCard().getFivesBool() && !getActivePlayer().getCard().getSixesBool()){
            combos += "\t5. Fives:    " + getCup().calculateFives() + "\t\t\t\t6. Sixes:    " + getCup().calculateSixes();
        }else if(!getActivePlayer().getCard().getFivesBool()){
            combos += "\t5. Fives:    " + getCup().calculateFives();
        }else if(!getActivePlayer().getCard().getSixesBool()){
            combos += "\t\t\t\t\t\t6. Sixes:    " + getCup().calculateSixes();
        }

        combos += "\n\n";

        if(!getActivePlayer().getCard().getThreeKindBool() && !getActivePlayer().getCard().getFourKindBool()){
            combos += "\t7. 3 of a kind:    " + getCup().calculateThreeKind() + "\t\t\t8. 4 of a kind:    " + getCup().calculateFourKind();
        }else if(!getActivePlayer().getCard().getThreeKindBool()){
            combos += "\t7. 3 of a kind:    " + getCup().calculateThreeKind();
        }else if(!getActivePlayer().getCard().getFourKindBool()){
            combos += "\t\t\t\t\t\t8. 4 of a kind:    " + getCup().calculateFourKind();
        }

        combos += "\n\n";

        if(!getActivePlayer().getCard().getFullHouseBool() && !getActivePlayer().getCard().getSmallStraightBool()){
            combos += "\t9. Full House:    " + getCup().calculateFullHouse() + "\t\t\t10. Sm Straight:    " + getCup().calculateSmallStraight();
        }else if(!getActivePlayer().getCard().getFullHouseBool()){
            combos += "\t9. Full House:    " + getCup().calculateFullHouse();
        }else if(!getActivePlayer().getCard().getSmallStraightBool()){
            combos += "\t\t\t\t\t\t10. Sm Straight:    " + getCup().calculateSmallStraight();
        }

        combos += "\n\n";

        if(!getActivePlayer().getCard().getLargeStraightBool() && !getActivePlayer().getCard().getYahtzeeBool()){
            combos += "\t11. Lg Straight:    " + getCup().calculateLargeStraight() + "\t\t\t12. YAHTZEE:    " + getCup().calculateYahtzee();
        }else if(!getActivePlayer().getCard().getLargeStraightBool()){
            combos += "\t11. Lg Straight:    " + getCup().calculateLargeStraight();
        }else if(!getActivePlayer().getCard().getYahtzeeBool()){
            combos += "\t\t\t\t\t\t12. YAHTZEE:    " + getCup().calculateYahtzee();
        }

        combos += "\n\n";

        if(!getActivePlayer().getCard().getChanceBool()){
            combos += "\t13. Chance:    " + getCup().calculateChance();
        }

        combos += "\n\n";

        combos += "\n\n\t0. Go Back\n";
        return combos;
    }

    // getters + setters
    public ArrayList<Player> getPlayers(){
        return this.players;
    }
    public void setPlayers(ArrayList<Player> players){
        this.players = players;
    }
    public Cup getCup(){
        return this.cup;
    }
    public void setCup(Cup cup){
        this.cup = cup;
    }
    public int getRound(){
        return this.round;
    }
    public void setRound(int round){
        this.round = round;
    }
    public boolean getOnline(){
        return online;
    }
    public void setOnline(boolean online){
        this.online = online;
    }

}