package menu;

import object.Game;
import command.Command;
import command.NoCommand;


public class GameMenu extends Menu {

    // attributes
    private Game game;
    private boolean isHost;

    // constructor
    public GameMenu(Game game, boolean isHost){
        this.game = game;
        this.isHost = isHost;
    }
    public GameMenu(boolean isHost){
        this.isHost = isHost;
    }

    // show how's turn is it, show eligible options to players
    @Override
    public void displayMenu(){
        System.out.print("Hello");
    }

    @Override
    public Command getCommand(int selection){
        switch(selection){
            // active + waiting


        }
        // no command found
        return new NoCommand();
    }

    // getters and setters
    public Game getGame(){
        return this.game;
    }
    public void setGame(Game game){
        this.game = game;
    }
    public boolean getIsHost(){
        return this.isHost;
    }
    public void setIsHost(boolean isHost){
        this.isHost = isHost;
    }
    
}