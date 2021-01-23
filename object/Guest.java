package object;

import online.Connection;

public class Guest extends Player {
    // attributes
    private Connection connection;

    // constructor
    public Guest(String name, Card card, Connection connection){
        super(name, card);
        this.connection = connection;

    }

    // wait until active player responsed
    public int getActivePlayerSelection(String activePlayerName){
        System.out.print("Waiting on " + activePlayerName + " to finish.\n");
        String numString = this.connection.read();
        return Integer.parseInt(numString);
    }


    // get selection from guest
    public int getGuestSelection(String activePlayerName){

        int selection = 99;
    
        // active
        if(this.getName().equals(activePlayerName)){
    
            selection = getSelectionFromTerminal();
            connection.write(String.valueOf(selection));

        }else{
            // not active / waiting on other players selection
            System.out.print("Waiting on " + activePlayerName + " to finish.\n");
            String numString = this.connection.read();
            selection = Integer.parseInt(numString);
        }
        return selection;
    }

    // get dice selection from guest or wait on another player
    public int getGuestDiceSelection(String activePlayerName){

        int selection = 0;

        if(this.getName().equals(activePlayerName)){

            // check if this player actually has any valid rolls
            int rolls = Integer.parseInt(this.connection.read());

            if(rolls==0){
                System.out.print("Sorry you have no more rolls available.\n");
                this.connection.write("no rolls");

            }else{
                String dicePicks = getDiceFromTerminal();
                this.connection.write(dicePicks);
            }
            selection = 9;
        }else{
            
            System.out.print("Waiting on " + activePlayerName + " to finish.\n");
            String numString = this.connection.read();
            selection = Integer.parseInt(numString);
        }
        return selection;
    }

    // getters + setters
    public Connection getConnection(){
        return this.connection;
    }
    public void setConnection(Connection connection){
        this.connection = connection;
    }
}