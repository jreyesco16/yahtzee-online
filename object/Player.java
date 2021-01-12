package object;

import java.net.*;
import object.Card;

abstract public class Player {

    // attributes
    private String name;
    private Card card;
    private boolean active;

    //constructor
    public Player(String name, Card card){
        this.name = name;
        this.card = card;
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
}