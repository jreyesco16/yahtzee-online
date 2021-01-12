package object;

import online.Connection;
import object.Card;

public class Guest extends Player {
    // attributes
    private Connection connection;

    // constructor
    public Guest(String name, Card card, Connection connection){
        super(name, card);
        this.connection = connection;

    }

    // getters + setters
    public Connection getConnection(){
        return this.connection;
    }
    public void setConnection(Connection connection){
        this.connection = connection;
    }
}