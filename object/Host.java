package object;

import online.Server;
import online.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Host extends Player {

    // attributes
    private Server server;
    private Game game;

    // constructor
    public Host(String name, Card card, Server server){
        super(name, card);
        this.server = server;
    }

    // wait for all players to connect
    public void createGame(Host host){
        // create ArrayList containing all players
        ArrayList<Player> players = new ArrayList<Player>();

        // wait for all players to join
        int count = 1;
        players.add(host);

        while(count != server.getNumberOfPlayers()){

            System.out.print("Waiting for " + (server.getNumberOfPlayers() - count) + " player to connect.\n");

            String name = "";

            try{
                // wait for a user to connect to server
                Socket socket = this.server.getServerSocket().accept();
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

                try{
                    // get the users name
                    name = in.readUTF();

                    // add the player to list
                    players.add(new Guest(name, new Card(), new Connection(socket)));
                    count++;
                }catch(Exception e){
                    System.out.print("Error when getter name from accepted player.\n");
                }

            }catch(Exception e){
                System.out.print("Error when accepting player.\n");
            }
            // inform host that player just joined
            System.out.print("Player " + name + " has joined.\n");
        }
        this.game = new Game(players, new Cup());
    }

    // send a message to all guests
    public void printToAllPlayers(String line){
        for(int i = 1; i < this.game.getPlayers().size(); i++){
            Guest guest = (Guest)this.game.getPlayers().get(i);
            guest.getConnection().write(line);
        }
    }

    // send a message to all guest except active player
    public void printToAllNonActivePlayers(String activePlayer, int selection){
        for(int i = 1; i < this.game.getPlayers().size(); i++){
            Guest guest = (Guest)this.game.getPlayers().get(i);
            if(activePlayer != guest.getName()){
                guest.getConnection().write(String.valueOf(selection));
            }else{
                continue;
            }
            
        }
    }
    
    // get selection from host
    public int getHostSelection(String activePlayerName){
        // print activePlayerName to all guest
        printToAllPlayers(activePlayerName);

        int selection = 99;
    
        // check if this player is active
        if(this.getName().equals(activePlayerName)){
    
            selection = getSelectionFromTerminal();
            printToAllPlayers(String.valueOf(selection));

        }else{
    
            Guest guest = (Guest)game.getAcitivePlayer();
    
            String numString = guest.getConnection().read();
            selection = Integer.parseInt(numString);
    
            printToAllNonActivePlayers(activePlayerName, selection);
        }
        return selection;
    }


    // either get dice from host or guest
    public int getHostDiceSelection(String activePlayerName){
        // print activePlayerName to all guest
        printToAllPlayers(activePlayerName);

         // check if this player is active
         if(this.getName().equals(activePlayerName)){
             if(this.getGame().getCup().getRolls() <= 0){
                System.out.print("Sorry you have no more rolls available.\n");
             }else{
                String dicePicks = getDiceFromTerminal();
                this.game.getCup().rerollDice(dicePicks);
             }
            
            printToAllPlayers(String.valueOf(9));

        }else{
    
            Guest guest = (Guest)game.getAcitivePlayer();

            guest.getConnection().write(String.valueOf(game.getCup().getRolls()));
    
            String dicePicks = guest.getConnection().read();

            this.game.getCup().rerollDice(dicePicks);
    
            printToAllNonActivePlayers(activePlayerName, 9);
        }
        return 9;
    }

    // getters & setters
    public Server getServer(){
        return this.server;
    }
    public void setServer(Server server){
        this.server = server;
    }
    public Game getGame(){
        return this.game;
    }
    public void setGame(Game game){
        this.game = game;
    }
}