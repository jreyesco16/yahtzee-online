package object;

public class Card {

    // attributes
    // upper selection
    private int aces;
    private boolean acesBool;
    private int twos;
    private boolean twosBool;
    private int threes;
    private boolean threesBool;
    private int fours;
    private boolean foursBool;
    private int fives;
    private boolean fivesBool;
    private int sixes;
    private boolean sixesBool;
    private int totalScore;
    private int bonus;
    private int total;

    // lower selection
    private int threeKind;
    private boolean threeKindBool;
    private int fourKind;
    private boolean fourKindBool;
    private int fullHouse;
    private boolean fullHouseBool;
    private int smallStraight;
    private boolean smallStraightBool;
    private int largeStraight;
    private boolean largeStraightBool;
    private int yahtzee;
    private boolean yahtzeeBool;
    private int chance;
    private boolean chanceBool;
    private int yahtzeeBonus;

    // totals
    private int totalLowerSelection;
    private int totalUpperSelection;
    private int grandTotal;


    // constructor
    public Card(){
        // upper selection
        this.aces = 0;
        this.acesBool = false;
        this.twos = 0;
        this.twosBool = false;
        this.threes = 0;
        this.threesBool = false;
        this.fours = 0;
        this.foursBool = false;
        this.fives = 0;
        this.fivesBool = false;
        this.sixes = 0;
        this.sixesBool = false;
        this.totalScore = 0;
        this.bonus = 0;
        this.total = 0;

        // lower selection
        this.threeKind = 0;
        this.threeKindBool = false;
        this.fourKind = 0;
        this.fourKindBool = false;
        this.fullHouse = 0;
        this.fullHouseBool = false;
        this.smallStraight = 0;
        this.smallStraightBool = false;
        this.largeStraight = 0;
        this.largeStraightBool = false;
        this.yahtzee = 0;
        this.yahtzeeBool = false;
        this.chance = 0;
        this.chanceBool = false;
        this.yahtzeeBonus = 0;
        this.totalLowerSelection = 0;
        this.totalUpperSelection = 0;
        this.grandTotal = 0;
    }

    // print out card
    public void printCard(){
        System.out.print("-------------UPPER SELECTION-------------\n");
        System.out.print("Aces: " + getAces() + "\n");
        System.out.print("Twos: " + getTwos() + "\n");
        System.out.print("Threes: " + getThrees() + "\n");
        System.out.print("Fours: " + getFours() + "\n");
        System.out.print("Fives: " + getFives() + "\n");
        System.out.print("Sixes: " + getSixes() + "\n");
        System.out.print("TOTAL SCORE --->: " + getTotalScore() + "\n");
        System.out.print("BONUS: " + getBonus() + "\n");
        System.out.print("TOTAL       --->: " + getTotal() + "\n");
        System.out.print("-------------Lower SELECTION-------------\n");
        System.out.print("3 of a kind: " + getThreeKind() + "\n");
        System.out.print("4 of a kind: " + getFourKind() + "\n");
        System.out.print("Fulle House: " + getFullHouse() + "\n");
        System.out.print("Sm Straight: " + getSmallStraight() + "\n");
        System.out.print("Lg Straight: " + getLargeStraight() + "\n");
        System.out.print("YAHTZEE: " + getYahtzee() + "\n");
        System.out.print("Chance: " + getChance() + "\n");
        System.out.print("\tYAHTZEE :" + getYahzeeBonus() + "\n");
        System.out.print("\t BONUS\n");
        System.out.print("Total Lower --->: " + getTotalLowerSelection() + "\n");
        System.out.print("Total upper --->: " + getTotalUpperSelection() + "\n");
        System.out.print("GRAND TOTAL --->: " + getGrandTotal() + "\n");
    }

    public boolean checkCompletion(){

        boolean check = false;
        
        if(this.acesBool && this.twosBool && this.threesBool && this.foursBool && this.fivesBool && this.sixesBool && this.threeKindBool && this.fourKindBool && this.fullHouseBool && this.smallStraightBool && this.largeStraightBool && this.yahtzeeBool && this.chanceBool){
            check = true;
        }

        return check;
    }

    // getters + setters
    public int getAces(){
        return this.aces;
    }
    public void setAces(int aces){
        this.aces = aces;
    }
    public boolean getAcesBool(){
        return this.acesBool;
    }
    public void setAcesBool(boolean acesBool){
        this.acesBool = acesBool;
    }
    public int getTwos(){
        return this.twos;
    }
    public void setTwos(int twos){
        this.twos = twos;
    }
    public boolean getTwosBool(){
        return this.twosBool;
    }
    public void setTwosBool(boolean twosBool){
        this.twosBool = twosBool;
    }
    public int getThrees(){
        return this.threes;
    }
    public void setThrees(int threes){
        this.threes = threes;
    }
    public boolean getThreesBool(){
        return this.threesBool;
    }
    public void setThreesBool(boolean threesBool){
        this.threesBool = threesBool;
    }
    public int getFours(){
        return this.fours;
    }
    public void setFours(int fours){
        this.fours = fours;
    }
    public boolean getFoursBool(){
        return this.foursBool;
    }
    public void setFoursBool(boolean foursBool){
        this.foursBool = foursBool;
    }
    public int getFives(){
        return this.fives;
    }
    public void setFives(int fives){
        this.fives = fives;
    }
    public boolean getFivesBool(){
        return this.fivesBool;
    }
    public void setFivesBool(boolean fivesBool){
        this.fivesBool = fivesBool;
    }
    public int getSixes(){
        return this.sixes;
    }
    public void setSixes(int sixes){
        this.sixes = sixes;
    }
    public boolean getSixesBool(){
        return this.sixesBool;
    }
    public void setSixesBool(boolean sixesBool){
        this.sixesBool = sixesBool;
    }
    public int getTotalScore(){
        return this.totalScore;
    }
    public void setTotalScore(int totalScore){
        this.totalScore = totalScore;
    }
    public int getBonus(){
        return this.bonus;
    }
    public void setBonus(int bonus){
        this.bonus = bonus;
    }
    public int getTotal(){
        return this.total;
    }
    public void setTotal(int total){
        this.total = total;
    }
    public int getThreeKind(){
        return this.threeKind;
    }
    public void setThreeKind(int threeKind){
        this.threeKind = threeKind;
    }
    public boolean getThreeKindBool(){
        return this.threeKindBool;
    }
    public void setThreeKindBool(boolean threeKindBool){
        this.threeKindBool = threeKindBool;
    }
    public int getFourKind(){
        return this.fourKind;
    }
    public void setFourKind(int fourKind){
        this.fourKind = fourKind;
    }
    public boolean getFourKindBool(){
        return this.fourKindBool;
    }
    public void setFourKindBool(boolean fourKindBool){
        this.fourKindBool = fourKindBool;
    }
    public int getFullHouse(){
        return this.fullHouse;
    }
    public void setFullHouse(int fullHouse){
        this.fullHouse = fullHouse;
    }
    public boolean getFullHouseBool(){
        return this.fullHouseBool;
    }
    public void setFullHouseBool(boolean fullHouseBool){
        this.fullHouseBool = fullHouseBool;
    }
    public int getSmallStraight(){
        return this.smallStraight;
    }
    public void setSmallStraight(int smallStraight){
        this.smallStraight = smallStraight;
    }
    public boolean getSmallStraightBool(){
        return this.smallStraightBool;
    }
    public void setSmallStraightBool(boolean smallStraightBool){
        this.smallStraightBool = smallStraightBool;
    }
    public int getLargeStraight(){
        return this.largeStraight;
    }
    public void setLargeStraight(int largeStraight){
        this.largeStraight = largeStraight;
    }
    public boolean getLargeStraightBool(){
        return this.largeStraightBool;
    }
    public void setLargeStraightBool(boolean largeStraightBool){
        this.largeStraightBool = largeStraightBool;
    }
    public int getYahtzee(){
        return this.yahtzee;
    }
    public void setYahtzee(int yahtzee){
        this.yahtzee = yahtzee;
    }
    public boolean getYahtzeeBool(){
        return this.yahtzeeBool;
    }
    public void setYahtzeeBool(boolean yahtzeeBool){
        this.yahtzeeBool = yahtzeeBool;
    }
    public int getChance(){
        return this.chance;
    }
    public void setChance(int chance){
        this.chance = chance;
    }
    public boolean getChanceBool(){
        return this.chanceBool;
    }
    public void setChanceBool(boolean chanceBool){
        this.chanceBool = chanceBool;
    }
    public int getYahzeeBonus(){
        return this.yahtzeeBonus * 100;
    }

    public void setYahtzeeBonus(int yahtzeeBonus){
        this.yahtzeeBonus = yahtzeeBonus;
    }
    public int getTotalLowerSelection(){
        return this.threeKind + this.fourKind + this.fullHouse + this.smallStraight + this.largeStraight + this.yahtzee + this.chance + getYahzeeBonus();
    }
    public void setTotalLowerSelection(int totalLowerSelection){
        this.totalLowerSelection = totalLowerSelection;
    }
    public int getTotalUpperSelection(){
        int lower = this.aces + this.twos + this.threes + this.fours + this.fives + this.sixes;
        return (lower >= 63) ? lower + 35 : lower;
    }
    public void setTotalUpperSelection(int totalUpperSelection){
        this.totalUpperSelection = totalUpperSelection;
    }
    public int getGrandTotal(){
        return getTotalLowerSelection() + getTotalUpperSelection();
    }
    public void setGrandTotal(int grandTotal){
        this.grandTotal = grandTotal;
    }
}  