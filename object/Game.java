package object;

import java.util.ArrayList;

public class Game {

    // attributes
    private ArrayList<Player> players;
    private Cup cup;
    private int activeIndex;
    private int round;

    // constructors
    public Game(ArrayList<Player> players, Cup cup){
        this.players = players;
        this.cup = cup;
        this.activeIndex = 0;
        this.round = 1;
    }

    // get active player
    public Player getAcitivePlayer(){
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
        String scoreBoard = "----------SCORE BOARD----------\n";
        int count = 1;

        // need to make a list that sorts the scoreboard before storing in a list

        for(int i = 0; i < players.size(); i++){
            scoreBoard = scoreBoard + count + ". " + players.get(i).getName() + ": " + players.get(i).getCard().getGrandTotal() + "\t\n" + "-------------------------------\n";
            count++;
        }

        return scoreBoard + "\n\n";
    }

    // create string to get all player scores
    public String getScoresString(){
        String scores = "--------UPPER SELECTION-------- \t"; for(Player p: players){ scores += String.format("%-8s\t", p.getName()+":"); };
        scores += "\nAces:                               \t"; for(Player p: players){ scores += String.format("%-8d\t", p.getCard().getAces()); };
        scores += "\nTwos:                               \t"; for(Player p: players){ scores += String.format("%-8d\t", p.getCard().getTwos()); };
        scores += "\nThrees:                             \t"; for(Player p: players){ scores += String.format("%-8d\t", p.getCard().getThrees()); };
        scores += "\nFours:                              \t"; for(Player p: players){ scores += String.format("%-8d\t", p.getCard().getFours()); };
        scores += "\nFives:                              \t"; for(Player p: players){ scores += String.format("%-8d\t", p.getCard().getFives()); };
        scores += "\nSixes:                              \t"; for(Player p: players){ scores += String.format("%-8d\t", p.getCard().getSixes()); };
        scores += "\nTOTAL SCORE --->:                   \t"; for(Player p: players){ scores += String.format("%-8d\t", p.getCard().getTotalScore()); };
        scores += "\nBONUS:                              \t"; for(Player p: players){ scores += String.format("%-8d\t", p.getCard().getBonus()); };
        scores += "\nTOTAL       --->:                   \t"; for(Player p: players){ scores += String.format("%-8d\t", p.getCard().getTotal()); };
		scores += "\n--------LOWER SELECTION--------";
        scores += "\n3 of a kind:                        \t"; for(Player p: players){ scores += String.format("%-8d\t", p.getCard().getThreeKind()); };
        scores += "\n4 of a kind:                        \t"; for(Player p: players){ scores += String.format("%-8d\t", p.getCard().getFourKind()); };
        scores += "\nFull House:                         \t"; for(Player p: players){ scores += String.format("%-8d\t", p.getCard().getFullHouse()); };
        scores += "\nSm Straight:                        \t"; for(Player p: players){ scores += String.format("%-8d\t", p.getCard().getSmallStraight()); };
        scores += "\nLg Straight:                        \t"; for(Player p: players){ scores += String.format("%-8d\t", p.getCard().getLargeStraight()); };
        scores += "\nYAHTZEE:                            \t"; for(Player p: players){ scores += String.format("%-8d\t", p.getCard().getYahtzee()); };
        scores += "\nChance:                             \t"; for(Player p: players){ scores += String.format("%-8d\t", p.getCard().getChance()); };
        scores += "\n    YAHTZEE :                       \t"; for(Player p: players){ scores += String.format("%-8d\t", p.getCard().getYahzeeBonus()); };
        scores += "\n     BONUS";
        scores += "\n\nTotal Lower --->:                   \t"; for(Player p: players){ scores += String.format("%-8d\t", p.getCard().getTotalLowerSelection()); };
        scores += "\nTotal upper --->:                   \t"; for(Player p: players){ scores += String.format("%-8d\t", p.getCard().getTotalUpperSelection()); };
        scores += "\nGRAND TOTAL --->:                   \t"; for(Player p: players){ scores += String.format("%-8d\t", p.getCard().getGrandTotal()); };

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

    // create string to get all player combos
    public String getCombosString(){
        String combos = "";

        if(!getAcitivePlayer().getCard().getAcesBool()){
            combos += "\n1. Aces:    " + getCup().calculateAces();
        }
        if(!getAcitivePlayer().getCard().getTwosBool()){
            combos += "\n2. Twos:    " + getCup().calculateTwos();
        }
        if(!getAcitivePlayer().getCard().getThreesBool()){
            combos += "\n3. Threes:    " + getCup().calculateThrees();
        }
        if(!getAcitivePlayer().getCard().getFoursBool()){
            combos += "\n4. Fours:    " + getCup().calculateFours();
        }
        if(!getAcitivePlayer().getCard().getFivesBool()){
            combos += "\n5. Fives:    " + getCup().calculateFives();
        }
        if(!getAcitivePlayer().getCard().getSixesBool()){
            combos += "\n6. Sixes:    " + getCup().calculateSixes();
        }
        if(!getAcitivePlayer().getCard().getThreeKindBool()){
            combos += "\n7. 3 of a kind:    " + getCup().calculateThreeKind();
        }
        if(!getAcitivePlayer().getCard().getFourKindBool()){
            combos += "\n8. 4 of a kind:    " + getCup().calculateFourKind();
        }
        if(!getAcitivePlayer().getCard().getFullHouseBool()){
            combos += "\n9. Full House:    " + getCup().calculateFullHouse();
        }
        if(!getAcitivePlayer().getCard().getSmallStraightBool()){
            combos += "\n10. Sm Straight:    " + getCup().calculateSmallStraight();
        }
        if(!getAcitivePlayer().getCard().getLargeStraightBool()){
            combos += "\n11. Lg Straight:    " + getCup().calculateLargeStraight();
        }
        if(!getAcitivePlayer().getCard().getYahtzeeBool()){
            combos += "\n12. YAHTZEE:    " + getCup().calculateYahtzee();
        }
        if(!getAcitivePlayer().getCard().getChanceBool()){
            combos += "\n13. Chance:    " + getCup().calculateChance();
        }

        combos += "\n\n0. Go Back\n";
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

}