package object;

public class Card {

    // attributes
    // upper selection
    private int aces;
    private int twos;
    private int threes;
    private int fours;
    private int fives;
    private int sixes;
    private int totalScore;
    private int bonus;
    private int total;

    // lower selection
    private int threeKind;
    private int fourKind;
    private int fullHouse;
    private int smallStraight;
    private int largeStraight;
    private int yahtzee;
    private int chance;
    private int yahtzeeBonus;

    // totals
    private int totalLowerSelection;
    private int totalUpperSelection;
    private int grandTotal;


    // constructor
    public Card(){
        this.aces = 0;
        this.twos = 0;
        this.threes = 0;
        this.fours = 0;
        this.fives = 0;
        this.sixes = 0;
        this.totalScore = 0;
        this.bonus = 0;
        this.total = 0;
        this.threeKind = 0;
        this.fourKind = 0;
        this.fullHouse = 0;
        this.smallStraight = 0;
        this.largeStraight = 0;
        this.yahtzee = 0;
        this.chance = 0;
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

    // getters + setters
    public int getAces(){
        return this.aces;
    }
    public void setAces(int aces){
        this.aces = aces;
    }
    public int getTwos(){
        return this.twos;
    }
    public void setTwos(int twos){
        this.twos = twos;
    }
    public int getThrees(){
        return this.threes;
    }
    public void setThrees(int threes){
        this.threes = threes;
    }
    public int getFours(){
        return this.fours;
    }
    public void setFours(int fours){
        this.fours = fours;
    }
    public int getFives(){
        return this.fives;
    }
    public void setFives(int fives){
        this.fives = fives;
    }
    public int getSixes(){
        return this.sixes;
    }
    public void setSixes(int sixes){
        this.sixes = sixes;
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
    public int getFourKind(){
        return this.fourKind;
    }
    public void setFourKind(int fourKind){
        this.fourKind = fourKind;
    }
    public int getFullHouse(){
        return this.fullHouse;
    }
    public void setFullHouse(int fullHouse){
        this.fullHouse = fullHouse;
    }
    public int getSmallStraight(){
        return this.smallStraight;
    }
    public void setSmallStraight(int smallStraight){
        this.smallStraight = smallStraight;
    }
    public int getLargeStraight(){
        return this.largeStraight;
    }
    public void setLargeStraight(int largeStraight){
        this.largeStraight = largeStraight;
    }
    public int getYahtzee(){
        return this.yahtzee;
    }
    public void setYahtzee(int yahtzee){
        this.yahtzee = yahtzee;
    }
    public int getChance(){
        return this.chance;
    }
    public void setChance(int chance){
        this.chance = chance;
    }
    public int getYahzeeBonus(){
        return this.yahtzeeBonus;
    }
    public void setYahtzeeBonus(int yahtzeeBonus){
        this.yahtzeeBonus = yahtzeeBonus;
    }
    public int getTotalLowerSelection(){
        return this.totalLowerSelection;
    }
    public void setTotalLowerSelection(int totalLowerSelection){
        this.totalLowerSelection = totalLowerSelection;
    }
    public int getTotalUpperSelection(){
        return this.totalUpperSelection;
    }
    public void setTotalUpperSelection(int totalUpperSelection){
        this.totalUpperSelection = totalUpperSelection;
    }
    public int getGrandTotal(){
        return this.grandTotal;
    }
    public void setGrandTotal(int grandTotal){
        this.grandTotal = grandTotal;
    }
}  