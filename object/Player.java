package object;

import java.util.Scanner;
import java.util.ArrayList;

abstract public class Player {

    // attributes
    private String name;
    private Card card;
    private boolean active;
    private boolean host;

    //constructor
    public Player(String name, Card card, boolean host){
        this.name = name;
        this.card = card;
        this.host = host;
    }

    public String getCardString(){
        return
        "-------------UPPER SELECTION-------------\n" +
        "Aces: " + this.card.getAces() + "\n" +
        "Twos: " + this.card.getTwos() + "\n" +
        "Threes: " + this.card.getThrees() + "\n" +
        "Fours: " + this.card.getFours() + "\n" +
        "Fives: " + this.card.getFives() + "\n" +
        "Sixes: " + this.card.getSixes() + "\n" +
        "TOTAL SCORE --->: " + this.card.getTotalScore() + "\n" +
        "BONUS: " + this.card.getBonus() + "\n" +
        "TOTAL       --->: " + this.card.getTotal() + "\n" +
        "-------------Lower SELECTION-------------\n" +
        "3 of a kind: " + this.card.getThreeKind() + "\n" +
        "4 of a kind: " + this.card.getFourKind() + "\n" +
        "Fulle House: " + this.card.getFullHouse() + "\n" +
        "Sm Straight: " + this.card.getSmallStraight() + "\n" +
        "Lg Straight: " + this.card.getLargeStraight() + "\n" +
        "YAHTZEE: " + this.card.getYahtzee() + "\n" +
        "Chance: " + this.card.getChance() + "\n" +
        "\tYAHTZEE :" + this.card.getYahzeeBonus() + "\n" +
        "\t BONUS\n" +
        "Total Lower --->: " + this.card.getTotalLowerSelection() + "\n" +
        "Total upper --->: " + this.card.getTotalUpperSelection() + "\n" +
        "GRAND TOTAL --->: " + this.card.getGrandTotal() + "\n";
    }

    public int getSelectionFromTerminal(){

        System.out.print("  Enter Selection: ");
        Scanner sc = new Scanner(System.in);
        int selection = 10000000;
        
        String selecTmp = sc.nextLine();
        
        try{
            selection = Integer.parseInt(selecTmp);
        }catch(Exception e){
            // user entered a selection that isn't an option
        }
        
        return selection;
    }
    
    public String getDiceFromTerminal(){

        boolean flag = false;

        Scanner sc = new Scanner(System.in);
        String dicePicks = "";

        System.out.print("\tEnter dice numbers with spaces between them you wish to re-roll or 0 to go back.\n\n");

        // bug user until they finally enter the corret format of string
        while(flag==false){
            System.out.print("  Enter Selection: ");
            dicePicks = sc.nextLine();

            // if user wants to go back to previous menus
            if(dicePicks.equals("0")){
                return dicePicks;
            }

            try{

                String [] tokens = dicePicks.split(" ");

                if(tokens.length < 1 || 5 < tokens.length){
                    System.out.print("\n\tYou have entered to many dice numbers.Try again.\n\n");
                    continue;
                }

                // test to make sure that all inputs by user are actual number
                boolean largerFlag = false;
                boolean repeatedFlag = false;
                ArrayList<Integer> diceNumbers = new ArrayList<Integer>();

                for(int i = 0; i < tokens.length; i++){
                    int num = Integer.parseInt(tokens[i]);
                    if(num<1 || 5<num){
                        largerFlag = true;
                    }else if(diceNumbers.contains(num)){ // find if the player has entered a repeated dice number
                        repeatedFlag = true;

                    }

                    diceNumbers.add(num);
                }

                if(largerFlag){
                    System.out.print("\n\tOnly dice numbers between 1-5 are valid. Try again.\n\n");
                }else if(repeatedFlag){
                    System.out.print("\n\tYou entered a the same dice number more than twice. Try again.\n\n");
                }else{
                    flag = true;
                }

            }catch(Exception e){
                System.out.print("\n\tThe format is incorrent, make sure to put spaces between dice numbers. Try again.\n\n");
            }
        }

        return dicePicks;
    }

    //getters & setters
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Card getCard(){
        return this.card;
    }
    public void setCard(Card card){
        this.card = card;
    }
    public boolean getActive(){
        return this.active;
    }
    public void setActive(boolean active){
        this.active = active;
    }
    public boolean getHost(){
        return this.host;
    }
    public void setHost(boolean host){
        this.host = host;
    }
}