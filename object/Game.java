package object;

import java.util.ArrayList;
import object.Card;
import object.Cup;
import object.Player;
import object.Guest;


public class Game {

    // attributes
    private ArrayList<Player> players;
    private Cup cup;


    // constructors
    public Game(ArrayList<Player> players, Cup cup){
        this.players = players;
        this.cup = cup;
    }

    // load game
    public void LoadGame(){
        for(int i = 1; i < players.size(); i++){
            // skip over host
            Guest guest = (Guest)players.get(i);
            guest.getConnection().write("Starting game...\n");
        }
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

}