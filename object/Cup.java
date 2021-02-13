package object;

import java.util.Random;

public class Cup {

    // attributes
    private int diceOne;
    private int diceTwo;
    private int diceThree;
    private int diceFour;
    private int diceFive;
    private Random random;
    private int rolls;

    
    // constructor
    public Cup(){
        this.diceOne = 0;
        this.diceTwo = 0;
        this.diceThree = 0;
        this.diceFour = 0;
        this.diceFive = 0;
        this.random = new Random();
        this.rolls = 3;

    }


/* CANT DECIDE IF THIS THIS SHOULD BE THE INITIAL VIEW OF DICE */
// " _____      _____      _____      _____      _____ "
// "|     |    |     |    |     |    |     |    |     |"
// "|  ?  |    |  ?  |    |  ?  |    |  ?  |    |  ?  |"
// "|     |    |     |    |     |    |     |    |     |"
// " '''''      '''''      '''''      '''''      ''''' "
//     1          2          3          4          5

    public String getDiceBuilderString(){

        String diceString = "\t\t _____      _____      _____      _____      _____ \n";

        // first initial roll
        if(rolls==3){
            this.diceOne = getRandomDiceNumber();
            this.diceTwo = getRandomDiceNumber();
            this.diceThree = getRandomDiceNumber();
            this.diceFour = getRandomDiceNumber();
            this.diceFive = getRandomDiceNumber();
            rolls--;
        }

        for(int i = 1; i < 4; i++){
            diceString = diceString + "\t\t" + getDiceString(this.diceOne, i) + "    " + getDiceString(this.diceTwo, i) + "    " + getDiceString(this.diceThree, i) + "    " + getDiceString(this.diceFour, i) + "    " + getDiceString(this.diceFive, i) + "\n";
        }

        diceString = diceString + "\t\t '''''      '''''      '''''      '''''      ''''' \n";

        return diceString;

    }

    public String getDiceString(int diceNum, int level){
        switch(diceNum){
            case 1:
                return getDiceOneString(level);
            case 2:
                return getDiceTwoString(level);
            case 3:
                return getDiceThreeString(level);
            case 4:
                return getDiceFourString(level);
            case 5:
                return getDiceFiveString(level);
            case 6:
                return getDiceSixString(level);
        }
        return null;
    }

    public String getDiceOneString(int level){
        switch(level){
            case 1:
                return "|     |";
            case 2:
                return "|  o  |";
            case 3:
                return "|     |";
        }
        return null;
    }

    public String getDiceTwoString(int level){
        switch(level){
            case 1:
                return "|o    |";
            case 2:
                return "|     |";
            case 3:
                return "|    o|";
        }
        return null;
    }

    public String getDiceThreeString(int level){
        switch(level){
            case 1:
                return "|o    |";
            case 2:
                return "|  o  |";
            case 3:
                return "|    o|";
        }
        return null;
    }

    public String getDiceFourString(int level){
        switch(level){
            case 1:
                return "|o   o|";
            case 2:
                return "|     |";
            case 3:
                return "|o   o|";
        }
        return null;
    }

    public String getDiceFiveString(int level){
        switch(level){
            case 1:
                return "|o   o|";
            case 2:
                return "|  o  |";
            case 3:
                return "|o   o|";
        }
        return null;
    }

    public String getDiceSixString(int level){
        switch(level){
            case 1:
                return "|o   o|";
            case 2:
                return "|o   o|";
            case 3:
                return "|o   o|";
        }
        return null;
    }

    public void rerollDice(String dicePicks){

        if(rolls == 0 || dicePicks.equals("0")){
            return;
        }

        String [] tokens = dicePicks.split(" ");


        for(int i = 0; i < tokens.length; i++){
            int num = Integer.parseInt(tokens[i]);
            if(num == 1){
                this.diceOne = getRandomDiceNumber();
            }else if(num == 2){
                this.diceTwo = getRandomDiceNumber();
            }else if(num == 3){
                this.diceThree = getRandomDiceNumber();
            }else if(num == 4){
                this.diceFour = getRandomDiceNumber();
            }else if(num == 5){
                this.diceFive = getRandomDiceNumber();
            }
        }
        rolls--;
    }

    public void resetCup(){
        this.diceOne = 0;
        this.diceTwo = 0;
        this.diceThree = 0;
        this.diceFour = 0;
        this.diceFive = 0;
        rolls = 3;
    }

    public int getRandomDiceNumber(){
        return this.random.nextInt(6)+1;
    }

    // calculate various scores
    public int calculateAces(){
        return calculateUpperHelper(1);
    }
    
    public int calculateTwos(){
        return calculateUpperHelper(2);
    }
    
    public int calculateThrees(){
        return calculateUpperHelper(3);
    }
    
    public int calculateFours(){
        return calculateUpperHelper(4);
    }
    
    public int calculateFives(){
        return calculateUpperHelper(5);
    }
    
    public int calculateSixes(){
        return calculateUpperHelper(6);
    }
    
    public int calculateThreeKind(){
        int num = 0;

        if(this.diceOne == this.diceTwo && this.diceTwo == this.diceThree){
            num = this.diceOne + this.diceTwo + this.diceThree + this.diceFour + this.diceFive;
        }else if(this.diceOne == this.diceTwo && this.diceTwo == this.diceFour){
            num = this.diceOne + this.diceTwo + this.diceThree + this.diceFour + this.diceFive;
        }else if(this.diceOne == this.diceTwo && this.diceTwo == this.diceFive){
            num = this.diceOne + this.diceTwo + this.diceThree + this.diceFour + this.diceFive;
        }else if(this.diceOne == this.diceThree && this.diceThree == this.diceFour){
            num = this.diceOne + this.diceTwo + this.diceThree + this.diceFour + this.diceFive;
        }else if(this.diceOne == this.diceThree && this.diceThree == this.diceFive){
            num = this.diceOne + this.diceTwo + this.diceThree + this.diceFour + this.diceFive;
        }else if(this.diceOne == this.diceFour && this.diceFour == this.diceFive){
            num = this.diceOne + this.diceTwo + this.diceThree + this.diceFour + this.diceFive;
        }else if(this.diceTwo == this.diceThree && this.diceThree == this.diceFour){
            num = this.diceOne + this.diceTwo + this.diceThree + this.diceFour + this.diceFive;
        }else if(this.diceTwo == this.diceThree && this.diceThree == this.diceFive){
            num = this.diceOne + this.diceTwo + this.diceThree + this.diceFour + this.diceFive;
        }else if(this.diceTwo == this.diceFour && this.diceFour == this.diceFive){
            num = this.diceOne + this.diceTwo + this.diceThree + this.diceFour + this.diceFive;
        }else if(this.diceThree == this.diceFour && this.diceFour == this.diceFive){
            num = this.diceOne + this.diceTwo + this.diceThree + this.diceFour + this.diceFive;
        }

        return num;
    }

    public int calculateFourKind(){
        int num = 0;

        if(this.diceOne == this.diceTwo && this.diceTwo == this.diceThree && this.diceThree == this.diceFour){
            num = this.diceOne + this.diceTwo + this.diceThree + this.diceFour + this.diceFive;
        }
        if(this.diceOne == this.diceTwo && this.diceTwo == this.diceThree && this.diceThree == this.diceFive){
            num = this.diceOne + this.diceTwo + this.diceThree + this.diceFour + this.diceFive;
        }
        if(this.diceTwo == this.diceThree && this.diceThree == this.diceFour && this.diceFour == this.diceFive){
            num = this.diceOne + this.diceTwo + this.diceThree + this.diceFour + this.diceFive;
        }
        return num;
    }

    public int calculateFullHouse(){

        boolean fullhouse = false;
        
        if(this.diceOne == this.diceTwo && this.diceTwo == this.diceThree && this.diceFour == this.diceFive){
            fullhouse = true;
        }else if(this.diceOne == this.diceTwo && this.diceTwo == this.diceFour && this.diceThree == this.diceFive){
            fullhouse = true;
        }else if(this.diceOne == this.diceTwo && this.diceTwo == this.diceFive && this.diceThree == this.diceFour){
            fullhouse = true;
        }else if(this.diceOne == this.diceThree && this.diceThree == this.diceFour && this.diceTwo == this.diceFive){
            fullhouse = true;
        }else if(this.diceOne == this.diceThree && this.diceThree == this.diceFive && this.diceTwo == this.diceFour){
            fullhouse = true;
        }else if(this.diceOne == this.diceFour && this.diceFour == this.diceFive && this.diceTwo == this.diceThree){
            fullhouse = true;
        }else if(this.diceTwo == this.diceThree && this.diceThree == this.diceFour && this.diceOne == this.diceFive){
            fullhouse = true;
        }else if(this.diceTwo == this.diceThree && this.diceThree == this.diceFive && this.diceOne == this.diceFour){
            fullhouse = true;
        }else if(this.diceTwo == this.diceFour && this.diceFour == this.diceFive && this.diceOne == this.diceThree){
            fullhouse = true;
        }else if(this.diceThree == this.diceFour && this.diceFour == this.diceFive && this.diceOne == this.diceTwo){
            fullhouse = true;
        }

        return fullhouse ? 25 : 0;
    }
    
    public int calculateSmallStraight(){

        boolean smallStraight = false;

        if(this.diceOne == 1 || this.diceTwo == 1 || this.diceThree == 1 || this.diceFour == 1 || this.diceFive == 1){
            if(this.diceOne == 2 || this.diceTwo == 2 || this.diceThree == 2 || this.diceFour == 2 || this.diceFive == 2){
                if(this.diceOne == 3 || this.diceTwo == 3 || this.diceThree == 3 || this.diceFour == 3 || this.diceFive == 3){
                    if(this.diceOne == 4 || this.diceTwo == 4 || this.diceThree == 4 || this.diceFour == 4 || this.diceFive == 4){
                        smallStraight = true;
                    }
                }
            }
        }else if(this.diceOne == 2 || this.diceTwo == 2 || this.diceThree == 2 || this.diceFour == 2 || this.diceFive == 2){
            if(this.diceOne == 3 || this.diceTwo == 3 || this.diceThree == 3 || this.diceFour == 3 || this.diceFive == 3){
                if(this.diceOne == 4 || this.diceTwo == 4 || this.diceThree == 4 || this.diceFour == 4 || this.diceFive == 4){
                    if(this.diceOne == 5 || this.diceTwo == 5 || this.diceThree == 5 || this.diceFour == 5 || this.diceFive == 5){
                        smallStraight = true;
                    }
                }

            }

        }else if(this.diceOne == 3 || this.diceTwo == 3 || this.diceThree == 3 || this.diceFour == 3 || this.diceFive == 3){
            if(this.diceOne == 4 || this.diceTwo == 4 || this.diceThree == 4 || this.diceFour == 4 || this.diceFive == 4){
                if(this.diceOne == 5 || this.diceTwo == 5 || this.diceThree == 5 || this.diceFour == 5 || this.diceFive == 5){
                    if(this.diceOne == 6 || this.diceTwo == 6 || this.diceThree == 6 || this.diceFour == 6 || this.diceFive == 6){
                        smallStraight = true;
                    }
                }
            }
        }

        return (smallStraight == true) ? 30 : 0;
    }
    
    public int calculateLargeStraight(){
        boolean largeStraight = false;

        if(this.diceOne == 1 || this.diceTwo == 1 || this.diceThree == 1 || this.diceFour == 1 || this.diceFive == 1){
            if(this.diceOne == 2 || this.diceTwo == 2 || this.diceThree == 2 || this.diceFour == 2 || this.diceFive == 2){
                if(this.diceOne == 3 || this.diceTwo == 3 || this.diceThree == 3 || this.diceFour == 3 || this.diceFive == 3){
                    if(this.diceOne == 4 || this.diceTwo == 4 || this.diceThree == 4 || this.diceFour == 4 || this.diceFive == 4){
                        if(this.diceOne == 5 || this.diceTwo == 5 || this.diceThree == 5 || this.diceFour == 5 || this.diceFive == 5){
                            largeStraight = true;
                        }
                    }
                }
            }
        }else if(this.diceOne == 2 || this.diceTwo == 2 || this.diceThree == 2 || this.diceFour == 2 || this.diceFive == 2){
            if(this.diceOne == 3 || this.diceTwo == 3 || this.diceThree == 3 || this.diceFour == 3 || this.diceFive == 3){
                if(this.diceOne == 4 || this.diceTwo == 4 || this.diceThree == 4 || this.diceFour == 4 || this.diceFive == 4){
                    if(this.diceOne == 5 || this.diceTwo == 5 || this.diceThree == 5 || this.diceFour == 5 || this.diceFive == 5){
                        if(this.diceOne == 6 || this.diceTwo == 6 || this.diceThree == 6 || this.diceFour == 6 || this.diceFive == 6){
                            largeStraight = true;
                        }
                    }
                }
            }
        }

        return (largeStraight == true) ? 35 : 0;
    }

    public int calculateYahtzee(){
        boolean yahtzee = false;

        if(this.diceOne == this.diceTwo && this.diceTwo == this.diceThree && this.diceThree == this.diceFour && this.diceFour == this.diceFive){
            yahtzee = true;
        }

        return yahtzee ? 50 : 0;
    }
    
    public int calculateChance(){
        return this.diceOne + this.diceTwo + this.diceThree + this.diceFour + this.diceFive;
    }

    public int calculateUpperHelper(int combo){
        int num = 0;

        if(this.diceOne == combo){
            num += this.diceOne;
        }
        if(this.diceTwo == combo){
            num += this.diceTwo;
        }
        if(this.diceThree == combo){
            num += this.diceThree;
        }
        if(this.diceFour == combo){
            num += this.diceFour;
        }
        if(this.diceFive == combo){
            num += this.diceFive;
        }
        return num;
    }

    // getters + setters
    public int getRolls(){
        return this.rolls;
    }
    public void setRolls(int rolls){
        this.rolls = rolls;
    }

    public int getDiceOne(){
        return diceOne;
    }
    public void setDiceOne(int diceOne){
        this.diceOne = diceOne;
    }
    public int getDiceTwo(){
        return diceTwo;
    }
    public void setDiceTwo(int diceTwo){
        this.diceTwo = diceTwo;
    }
    public int getDiceThree(){
        return diceThree;
    }
    public void setDiceThree(int diceThree){
        this.diceThree = diceThree;
    }
    public int getDiceFour(){
        return diceFour;
    }
    public void setDiceFour(int diceFour){
        this.diceFour = diceFour;
    }
    public int getDiceFive(){
        return diceFive;
    }
    public void setDiceFive(int diceFive){
        this.diceFive = diceFive;
    }



}
