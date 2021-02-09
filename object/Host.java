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
        super(name, card, true);
        this.server = server;
    }

    // wait for all players to connect
    public void createOnlineGame(Host host){
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
        this.game = new Game(players, new Cup(), true);
    }

    // set up a local game
    public void createLocalGame(Host host){
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(host);

        int numOfPlayers = getNumberOfPlayers();

        Scanner sc = new Scanner(System.in);

        for(int i = 1; i < numOfPlayers ; i++){
            // get user's name
            boolean flag = false;
            String name = "";

            while(flag == false){

                System.out.print("\nEnter the name of player "+(i+1)+": ");
                name = sc.nextLine();

                if(name.length()>7){
                    System.out.print("\nName can't be larger than 7 letters long. Try again.\n");
                }else{
                    flag = true;
                }
            }

            Guest guest = new Guest(name, new Card(), null);

            players.add(guest);
        }

        this.game = new Game(players, new Cup(), false);
    }

     // set up the how many players will be in the game
     public int getNumberOfPlayers(){
        Scanner sc = new Scanner(System.in);
        boolean got = false;
        int playersNum = 0;

        // keep bugging user until they enter 
        while(!got){
            System.out.print("\nEnter the number of players (up to 4 including host): ");
            String players = sc.nextLine();

            try{
                playersNum = Integer.parseInt(players);

                if(0 < playersNum & playersNum < 5){
                    got = true;
                }else{
                    System.out.print("The number ented must be greater than 1 and smaller or equal to 4, try again.\n");
                    continue;
                }
            }catch(Exception e){
                System.out.print("You didn't enter a number, try again.\n");
                continue;
            }
        }
        return playersNum;
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

    public void printToAllNonActivePlayers(String activePlayer, String dicePicks){
        for(int i = 1; i < this.game.getPlayers().size(); i++){
            Guest guest = (Guest)this.game.getPlayers().get(i);
            if(activePlayer != guest.getName()){
                guest.getConnection().write(dicePicks);
            }else{
                continue;
            }
            
        }
    }
    
    // get selection from host
    public int getHostSelection(String activePlayerName){

        int selection = 999;

        if(game.getOnline()){
    
            // check if this player is active
            if(this.getName().equals(activePlayerName)){
    
                selection = getSelectionFromTerminal();
                printToAllPlayers(String.valueOf(selection));

            }else{
    
                Guest guest = (Guest)game.getActivePlayer();

                System.out.print("\t\t\t\tWaiting on " + activePlayerName + " to finish.\n");
    
                String numString = guest.getConnection().read();
                selection = Integer.parseInt(numString);
    
                printToAllNonActivePlayers(activePlayerName, selection);
            }

        }else{
            selection = getSelectionFromTerminal();
        }

        return selection;
    }

    // either get dice from host or guest
    public String getHostDiceSelection(String activePlayerName){
        
        String dicePicks = null;


        // ONLINE
        if(game.getOnline()){


            // HOST TURN
            if(this.getName().equals(activePlayerName)){

                   dicePicks = (game.getCup().getRolls() > 0) ? getDiceFromTerminal() : null;

            // NOT HOST TURN
            }else{
               Guest guest = (Guest)game.getActivePlayer();
   
               guest.getConnection().write(String.valueOf(game.getCup().getRolls()));

               System.out.print("\t\t\t\tWaiting on " + activePlayerName + " to finish.\n");
       
               dicePicks = guest.getConnection().read();
            }

            printToAllNonActivePlayers(activePlayerName, dicePicks);


        // LOCAL
        }else{

            dicePicks = (game.getCup().getRolls() > 0) ? getDiceFromTerminal() : null;
        }

        return dicePicks;
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